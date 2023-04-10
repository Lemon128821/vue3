package com.service;

import com.pojo.Employee;
import com.pojo.QueryObject;
import com.pojo.User;

import java.util.List;

public interface EmployeeService {

    Employee selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    boolean insert(Employee employee);

    List<Employee> selectAll(QueryObject queryObject);

    boolean updateByPrimaryKey(Employee employee);

    int deleteByIds(List<Integer> ids);

    boolean verifyInsert(String loginName);

}
