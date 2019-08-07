package com.example.shirodemo.mapper;

import com.example.shirodemo.model.dao.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/1 16:55
 * @ Modified By:
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where nickname=#{nickname}")
    Users findUserByName(@Param("nickname") String nickname);

    @Select("select * from user where isrealname in (1)")
    List<Users> getListUser();

    @Select("select count(*) from user where nickname=#{nickname}")
    int existUserByName(@Param("nickname") String nickname);
}
