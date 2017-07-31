package com.hawkingrei;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public abstract class BaseTests {

	protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	protected String mockStr(int length) {
		return UUID.randomUUID().toString()
				.replaceAll("-", "")
				.substring(0, Math.min(32, length));
	}

	protected int mockInt() {
		return this.mockInt(10000);
	}

	protected int mockInt(int max) {
		return this.mockInt(0, max);
	}

	protected int mockInt(int min, int max) {
		return RandomUtils.nextInt(min, max);
	}

	protected long mockLong() {
		return this.mockLong(10000);
	}

	protected long mockLong(long max) {
		return this.mockLong(0, max);
	}

	protected long mockLong(long min, long max) {
		return RandomUtils.nextLong(min, max);
	}

	protected short mockShort() {
		return this.mockShort(100);
	}

	protected short mockShort(int max) {
		return this.mockShort(0, max);
	}

	protected short mockShort(int min, int max) {
		return new Integer(RandomUtils.nextInt(min, max)).shortValue();
	}

	protected BigDecimal mockMoney(int maxYuan) {
		return new BigDecimal(mockInt(maxYuan - 1) + "." + mockInt(99));
	}

	protected String mockEmail() {
		return mockStr(10) + "@mock.com";
	}

	protected String mockMobile() {
		return "186" + mockLong(10000000, 99999999);
	}

}
