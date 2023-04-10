package com.service.impl;

import com.mapper.PermissionMapper;
import com.mapper.RolePermissionMapper;
import com.pojo.Permission;
import com.pojo.QueryObject;
import com.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<Permission> selectAll(QueryObject queryObject) {
        List<Permission> permissions = permissionMapper.selectAll(queryObject);
        return permissions;
    }

    @Override
    public List<Integer> selectByRoleId(Integer roleId) {
        List<Integer> permissionIds = rolePermissionMapper.selectByRoleId(roleId);
        return permissionIds;
    }

    @Override
    public int allotPermission(QueryObject queryObject) {
        Integer roleId = queryObject.getRoleId();
        List<Integer> permissionIds = queryObject.getPermissionIds();
        rolePermissionMapper.deleteByRoleId(roleId);
        int insert = 0;
        if (permissionIds != null && permissionIds.size() > 0) {
            for (Integer permissionId : permissionIds) {
                insert += rolePermissionMapper.insert(roleId, permissionId);
            }
        }
        return insert;
    }

    @Override
    public List<String> selectExpressionByEmployeeId(Integer employeeId) {
        List<String> expression = permissionMapper.selectExpressionByEmployeeId(employeeId);
        return expression;
    }
}
