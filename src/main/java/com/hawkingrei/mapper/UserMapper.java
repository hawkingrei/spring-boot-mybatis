package com.hawkingrei.mapper;

import com.hawkingrei.bean.po.UserPO;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * Created by hawkingrei on 2017/7/5.
 */
@Mapper
@Repository
public interface UserMapper {
  @Select("SELECT email, nickname, password FROM user WHERE email = #{email} LIMIT 1")
  UserPO loadByEmail(@Param("email") String email);

  @Insert("INSERT INTO user (email, nickname, password) VALUES (#{email}, #{nickname}, #{password})")
  int createUser(@Param("email") String email, @Param("nickname") String nickname, @Param("password") String password);
}
