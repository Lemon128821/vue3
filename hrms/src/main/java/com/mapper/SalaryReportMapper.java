package com.mapper;

import com.pojo.QueryObject;
import com.pojo.SalaryReport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalaryReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SalaryReport salaryReport);

    SalaryReport selectByPrimaryKey(Integer id);

    List<SalaryReport> selectAll(QueryObject queryObject);

    int updateByPrimaryKey(SalaryReport salaryReport);

    SalaryReport selectByEmpIdAndPayrollId(SalaryReport salaryReport);

    List<SalaryReport> selectByPayrollId(Integer payrollId);

    int deleteByIds(@Param("ids") int[] ids);

    int deleteByPayrollId(Integer payrollId);

    int deleteByPayrollIds(@Param("payrollIds") int[] payrollIds);

    int deleteByEmpId(Integer empId);

}