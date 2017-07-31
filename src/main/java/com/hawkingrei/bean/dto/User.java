package com.hawkingrei.bean.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
/**
 * Created by loveknut on 2017/7/5.
 */

@Data
@NoArgsConstructor
@ToString(exclude = "password")
public class User implements Serializable {
  private String email;
  private String nickname;
  private String password;
}

