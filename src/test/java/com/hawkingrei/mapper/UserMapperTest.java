package com.hawkingrei.mapper;

import com.hawkingrei.BaseTests;
import com.hawkingrei.bean.po.UserPO;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by hawkingrei on 2017/7/28.
 */
@SpringBootTest
public class UserMapperTest extends BaseTests{

  @Autowired
  private UserMapper userMapper;

  @Test
  public void loadByEmail() throws Exception {
    String email = mockEmail();
    String password = mockStr(32);

    int affect = userMapper.createUser(email, "nickname", password);
    assertTrue(affect > 0);

    UserPO user = userMapper.loadByEmail(email);
    assertThat(user.getEmail(), is(email));
    assertThat(user.getPassword(), is(password));

  }
}
