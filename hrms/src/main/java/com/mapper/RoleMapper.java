package com.mapper;

import com.pojo.QueryObject;
import com.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role role);

    Role selectByPrimaryKey(Integer id);

    List<Role> selectAll(QueryObject queryObject);

    int updateByPrimaryKey(Role role);

    int deleteByIds(@Param("ids") List<Integer> ids);

    Role selectByName(String name);
}