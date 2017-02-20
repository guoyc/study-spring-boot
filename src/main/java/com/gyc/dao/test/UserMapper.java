package com.gyc.dao.test;

import com.gyc.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;

/**
 * @author yc.guo@zuche.com on 2017/2/17.
 */
@Mapper
@CacheConfig(cacheNames = "users")
public interface UserMapper {

    @Select("SELECT id, name FROM user WHERE name = #{name}")
    User getUserByName(@Param("name") String name);

    @Insert("INSERT INTO user(name) VALUES(#{name})")
    int addUser(@Param("name") String name);

    @Select("SELECT id, name FROM user")
    List<User> getAllUser();
}
