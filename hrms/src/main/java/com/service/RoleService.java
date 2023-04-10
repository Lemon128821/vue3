package com.service;

import com.pojo.EmployeeRole;
import com.pojo.QueryObject;
import com.pojo.Role;
import java.util.List;

public interface RoleService {

    List<Role> selectAll(QueryObject queryObject);

    int deleteByPrimaryKey(Integer id);

    boolean insert(Role role);

    Role selectByPrimaryKey(Integer id);

    boolean updateByPrimaryKey(Role role);

    int deleteByIds(List<Integer> ids);

    List<Integer> selectByEmployeeId(Integer employeeId);

    int allotRole(QueryObject queryObject);
}
