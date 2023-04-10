package com.mapper;

import com.pojo.Payroll;
import com.pojo.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayrollMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Payroll payroll);

    Payroll selectByPrimaryKey(Integer id);

    List<Payroll> selectAll();

    int updateByPrimaryKey(Payroll payroll);

    Payroll selectByName(String name);

    int deleteByIds(@Param("ids") int[] ids);
}