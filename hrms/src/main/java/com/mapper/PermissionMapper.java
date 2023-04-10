package com.mapper;

import com.pojo.Permission;
import com.pojo.QueryObject;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission permission);

    Permission selectByPrimaryKey(Integer id);

    List<Permission> selectAll(QueryObject queryObject);

    int updateByPrimaryKey(Permission permission);

    List<String> selectExpressionByEmployeeId(Integer employeeId);

}