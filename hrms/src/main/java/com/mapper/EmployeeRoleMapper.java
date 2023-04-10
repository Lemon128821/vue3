package com.mapper;

import com.pojo.EmployeeRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(@Param("employeeId") Integer employeeId, @Param("roleId") Integer roleId);

    EmployeeRole selectByPrimaryKey(Integer id);

    List<EmployeeRole> selectAll();

    int updateByPrimaryKey(EmployeeRole employeeRole);

    List<Integer> selectByEmployeeId(Integer employeeId);

    int deleteByEmployeeId(Integer employeeId);

    int deleteByRoleId(Integer roleId);
}