package com.mapper;

import com.pojo.Employee;
import com.pojo.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee employee);

    Employee selectByPrimaryKey(Integer id);

    List<Employee> selectAll(QueryObject queryObject);

    int updateByPrimaryKey(Employee employee);

    int deleteByIds(@Param("ids") List<Integer> ids);

    Employee selectByEmpNum(String empNum);

    int deleteByDeptIds(@Param("ids") List<Integer> ids);

    List<Integer> selectByDeptIds(@Param("ids") List<Integer> ids);

    String selectLeader(Integer id);
}