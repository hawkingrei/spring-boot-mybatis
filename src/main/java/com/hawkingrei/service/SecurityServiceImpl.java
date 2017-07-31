package com.hawkingrei.service;

import com.google.common.base.Preconditions;
import com.hawkingrei.bean.dto.User;
import com.hawkingrei.bean.po.UserPO;
import com.hawkingrei.cache.service.UserCache;
import com.hawkingrei.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

import javax.annotation.Resource;

/**
 * Created by hawkingrei on 2017/7/31.
 */
@Service
@Slf4j
public class SecurityServiceImpl implements SecurityService {
  @Resource
  private UserCache userCache;
  @Resource
  private UserMapper userMapper;

  @Override
  public String signIn(String email, String password) {
    UserPO userPO = userMapper.loadByEmail(email);
    Preconditions.checkNotNull(userPO, "user not exists");
    Preconditions.checkArgument(userPO.getPassword().equals(password), "email or password incorrect");

    User user = new User();
    BeanUtils.copyProperties(userPO, user);

    String sessionId = UUID.randomUUID().toString();
    userCache.saveSession(user, sessionId);
    return sessionId;
  }

  @Override
  public String signUp(String email, String password, String nickname) {
    return null;
  }

  @Override
  public User fetchUser(final String sessionId) {
    try {
      return userCache.loadBySessionId(sessionId);
    } catch (Exception e) {
      log.error("fetch user in redis failed", e);
      return null;
    }
  }
}
