package com.controller;

import com.pojo.*;
import com.service.EmployeeService;
import com.service.PayrollService;
import com.service.SalaryReportService;
import com.util.RequirePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/salaryReport")
public class SalaryReportController {
    @Autowired
    private SalaryReportService salaryReportService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PayrollService payrollService;

    @RequestMapping("/deleteById")
    @RequirePermission({"删除薪资记录信息","salaryReport:delete"})
    public Response<SalaryReport> deleteByPrimaryKey(@RequestBody Integer id) {
        int delete = salaryReportService.deleteByPrimaryKey(id);
        Response<SalaryReport> response = new Response<>(0, "删除薪资记录成功", null);
        return response;
    }

    @RequestMapping("/deleteByIds")
    @RequirePermission({"删除薪资记录信息","salaryReport:delete"})
    public Response<SalaryReport> deleteByIds(@RequestBody int[] ids) {
        int delete = salaryReportService.deleteByIds(ids);
        Response<SalaryReport> response = new Response<>(0, "批量删除薪资记录成功", null);
        return response;
    }

    @RequestMapping("/insert")
    @RequirePermission({"新增薪资记录信息","salaryReport:insert"})
    public Response<SalaryReport> insert(@RequestBody SalaryReport salaryReport) {
        boolean insert = salaryReportService.insert(salaryReport);
        if (insert) {
            Response<SalaryReport> response = new Response<>(0, "添加薪资记录成功", null);
            return response;
        }
        Response<SalaryReport> response = new Response<>(1, "当前薪资记录已存在，添加薪资记录失败", null);
        return response;
    }

    @RequestMapping("/selectById")
    @RequirePermission({"编辑薪资记录信息","salaryReport:edit"})
    public Response<SalaryReport> selectByPrimaryKey(@RequestBody Integer id) {
        SalaryReport salaryReport = salaryReportService.selectByPrimaryKey(id);
        ResponseData<SalaryReport> data = new ResponseData<>();
        data.setObject(salaryReport);
        Response<SalaryReport> response = new Response<>(0, "根据id查询薪资记录", data);
        return response;
    }

    @RequestMapping("/selectByPayrollId")
    @RequirePermission({"查看薪资项目的薪资报表信息","payroll:selectByPayrollId"})
    public Response<SalaryReport> selectByPayrollId(@RequestBody Integer payrollId) {
        List<SalaryReport> salaryReports = salaryReportService.selectByPayrollId(payrollId);
        ResponseData<SalaryReport> data = new ResponseData<>();
        data.setList(salaryReports);
        Response<SalaryReport> response = new Response<>(0, "根据payrollId查询薪资记录", data);
        return response;
    }

    @RequestMapping("/selectAll")
    @RequirePermission({"查看薪资记录信息","salaryReport:select"})
    public Response<SalaryReport> selectAll(@RequestBody QueryObject queryObject) {
        List<SalaryReport> salaryReports = salaryReportService.selectAll(queryObject);
        List<Employee> employees = employeeService.selectAll(new QueryObject());
        List<Payroll> payrolls = payrollService.selectAll();
        ResponseData<SalaryReport> data = new ResponseData<>();
        data.setList(salaryReports);
        data.setListTwo(employees);
        data.setListThree(payrolls);
        Response<SalaryReport> response = new Response<>(0, "查询薪资记录", data);
        return response;
    }

    @RequestMapping("/updateById")
    @RequirePermission({"编辑薪资记录信息","salaryReport:edit"})
    public Response<SalaryReport> updateByPrimaryKey(@RequestBody SalaryReport salaryReport) {
        boolean update = salaryReportService.updateByPrimaryKey(salaryReport);
        if (update) {
            Response<SalaryReport> response = new Response<>(0, "修改薪资记录成功", null);
            return response;
        }
        Response<SalaryReport> response = new Response<>(1, "当前薪资记录已存在，修改薪资记录失败", null);
        return response;
    }
}
