package com.hawkingrei.service;

import com.hawkingrei.bean.dto.User;

/**
 * Created by loveknut on 2017/7/5.
 */
public interface SecurityService {
  String signIn(String email, String password);
  String signUp(String email, String password, String nickname);
  User fetchUser(String sessionId);
}
