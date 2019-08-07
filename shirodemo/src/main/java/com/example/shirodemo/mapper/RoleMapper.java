package com.example.shirodemo.mapper;


import com.example.shirodemo.model.dao.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/3/21 9:46
 * @ Modified By:
 */
@Mapper
public interface RoleMapper {
    @Select("select * from role where id=#{id}")
    Role findRoleById(Integer id);

    @Select("select * from role")
    List<Role> getAllRole();
}
