package com.hawkingrei.controller;

import com.hawkingrei.bean.dto.User;
import com.hawkingrei.cache.service.UserCache;
import com.hawkingrei.service.SecurityService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by hawkingrei on 2017/7/28.
 */
@RestController
@RequestMapping("security")
public class SecurityController {
  @Resource
  private SecurityService securityService;
  @Resource
  private UserCache userCache;

  @RequestMapping(value = "signin", method = POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public String signIn(
      @RequestParam String email,
      @RequestParam String password) {
    return securityService.signIn(email, password);
  }

  @RequestMapping(value = "signup", method = POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public String signUp(
      @RequestParam String email,
      @RequestParam String password,
      @RequestParam String nickname) {
    return securityService.signUp(email, password, nickname);
  }

  @RequestMapping(value = "info", method = POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public User fetchUser(@CookieValue("session_id") String sessionId) {
    return securityService.fetchUser(sessionId);
  }
}
