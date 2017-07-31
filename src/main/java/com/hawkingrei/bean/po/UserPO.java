package com.hawkingrei.bean.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by hawkingrei on 2017/7/27.
 */
@Data
@ToString(exclude = "password")
@NoArgsConstructor
public class UserPO {
  private String email;
  private String nickname;
  private String password;
}

