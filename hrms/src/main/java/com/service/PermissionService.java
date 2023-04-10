package com.service;

import com.pojo.Permission;
import com.pojo.QueryObject;

import java.util.List;

public interface PermissionService {

    List<Permission> selectAll(QueryObject queryObject);

    List<Integer> selectByRoleId(Integer roleId);

    int allotPermission(QueryObject queryObject);

    List<String> selectExpressionByEmployeeId(Integer employeeId);

}
