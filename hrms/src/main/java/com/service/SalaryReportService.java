package com.service;

import com.pojo.QueryObject;
import com.pojo.SalaryReport;

import java.util.List;

public interface SalaryReportService {

    int deleteByPrimaryKey(Integer id);

    boolean insert(SalaryReport salaryReport);

    SalaryReport selectByPrimaryKey(Integer id);

    List<SalaryReport> selectAll(QueryObject queryObject);

    boolean updateByPrimaryKey(SalaryReport salaryReport);

    List<SalaryReport> selectByPayrollId(Integer payrollId);

    int deleteByIds(int[] ids);
}
