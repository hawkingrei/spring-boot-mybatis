package com.hawkingrei.cache.key;

import com.google.common.base.Preconditions;

import lombok.Builder;

/**
 * Created by loveknut on 2017/7/5.
 */
@Builder
public class SessionKey extends CacheKey {
  private static final String VERSION = "1";
  private String sessionId;

  @Override
  public String buildKey() {
    return String.format("%s:%s:v:%s:sid:%s",
        DOMAIN, getClass().getCanonicalName(), VERSION,
        Preconditions.checkNotNull(sessionId)
    );
  }
}
