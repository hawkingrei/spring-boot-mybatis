package com.hawkingrei.cache.service;

import com.hawkingrei.bean.dto.User;

/**
 * Created by loveknut on 2017/7/5.
 */
public interface  UserCache {
  User loadBySessionId(String sessionId);

  void saveSession(User user, String sessionId);
}
