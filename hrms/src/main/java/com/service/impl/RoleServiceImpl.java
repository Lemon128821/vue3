package com.service.impl;

import com.mapper.EmployeeRoleMapper;
import com.mapper.RoleMapper;
import com.mapper.RolePermissionMapper;
import com.pojo.QueryObject;
import com.pojo.Role;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private EmployeeRoleMapper employeeRoleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<Role> selectAll(QueryObject queryObject) {
        List<Role> roles = roleMapper.selectAll(queryObject);
        return roles;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int delete = roleMapper.deleteByPrimaryKey(id);
        rolePermissionMapper.deleteByRoleId(id);
        employeeRoleMapper.deleteByRoleId(id);
        return delete;
    }

    @Override
    public boolean insert(Role role) {
        Role selectByName = roleMapper.selectByName(role.getName());
        if (selectByName == null) {
            roleMapper.insert(role);
            return true;
        }
        return false;
    }

    @Override
    public Role selectByPrimaryKey(Integer id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        return role;
    }

    @Override
    public boolean updateByPrimaryKey(Role role) {
        Role selectByName = roleMapper.selectByName(role.getName());
        if (selectByName == null) {
            roleMapper.updateByPrimaryKey(role);
            return true;
        } else {
            Role selectByPrimaryKey = roleMapper.selectByPrimaryKey(role.getId());
            if (selectByPrimaryKey.getName().equals(role.getName())) {
                roleMapper.updateByPrimaryKey(role);
                return true;
            }
        }
        return false;
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        int delete = roleMapper.deleteByIds(ids);
        for (Integer id : ids) {
            rolePermissionMapper.deleteByRoleId(id);
            employeeRoleMapper.deleteByRoleId(id);
        }
        return delete;
    }

    @Override
    public List<Integer> selectByEmployeeId(Integer employeeId) {
        List<Integer> roleIds = employeeRoleMapper.selectByEmployeeId(employeeId);
        return roleIds;
    }

    @Override
    public int allotRole(QueryObject queryObject) {
        Integer employeeId = queryObject.getEmployeeId();
        List<Integer> roleIds = queryObject.getRoleIds();
        employeeRoleMapper.deleteByEmployeeId(employeeId);
        int insert = 0;
        if (roleIds != null && roleIds.size() > 0) {
            for (Integer roleId : roleIds) {
                insert += employeeRoleMapper.insert(employeeId, roleId);
            }
        }
        return insert;
    }
}
