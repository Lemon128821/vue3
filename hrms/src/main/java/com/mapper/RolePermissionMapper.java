package com.mapper;

import com.pojo.RolePermission;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId);

    RolePermission selectByPrimaryKey(Integer id);

    List<RolePermission> selectAll();

    int updateByPrimaryKey(RolePermission rolePermission);

    List<Integer> selectByRoleId(Integer roleId);

    int deleteByRoleId(Integer roleId);
}