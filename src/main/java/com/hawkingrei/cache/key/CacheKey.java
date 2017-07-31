package com.hawkingrei.cache.key;

/**
 * Created by loveknut on 2017/7/5.
 */
public abstract class CacheKey {
  protected static final String DOMAIN = "demo";

  abstract String buildKey();
}
