package com.mapper;

import com.pojo.Department;
import com.pojo.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department department);

    Department selectByPrimaryKey(Integer id);

    List<Department> selectAll(QueryObject queryObject);

    List<Department> selectByPId(Integer pId);

    List<Department> selectByFirst();

    int updateByPrimaryKey(Department department);

    int deleteByIds(@Param("ids") List<Integer> ids);

    Department selectByName(String name);

    List<Department> selectOptionalParentDepartment(@Param("ids") List<Integer> ids);
}