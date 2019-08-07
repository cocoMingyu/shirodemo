package com.example.shirodemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ Author kn
 * @ Description
 * @ Date 2019/8/3 17:27
 */
@Mapper

public interface UserRoleMapper {
    @Select("select roleid from user_role where userid=#{userid}")
    List<Integer> getRoleByUserid(@Param("userid")Integer userid);
}
