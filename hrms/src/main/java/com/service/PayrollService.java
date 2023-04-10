package com.service;

import com.pojo.Payroll;

import java.util.List;

public interface PayrollService {

    int deleteByPrimaryKey(Integer id);

    boolean insert(Payroll payroll);

    Payroll selectByPrimaryKey(Integer id);

    List<Payroll> selectAll();

    boolean updateByPrimaryKey(Payroll payroll);

    int deleteByIds(int[] ids);
}
