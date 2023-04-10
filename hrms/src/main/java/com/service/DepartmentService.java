package com.service;

import com.pojo.Department;
import com.pojo.QueryObject;

import java.util.List;

public interface DepartmentService {
    int deleteByPrimaryKey(Integer id);

    boolean insert(Department department);

    Department selectByPrimaryKey(Integer id);

    List<Department> selectAll(QueryObject queryObject);

    List<Department> selectByFirst();

    boolean updateByPrimaryKey(Department department);

    int deleteByIds(List<Integer> ids);

    List<Department> selectOptionalParentDepartment(Integer id);
}
