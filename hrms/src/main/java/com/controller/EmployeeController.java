package com.controller;

import com.pojo.*;
import com.service.DepartmentService;
import com.service.EmployeeService;
import com.util.RequirePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/selectById")
    @RequirePermission({"编辑员工信息","employee:edit"})
    public Response<Employee> selectByPrimaryKey(@RequestBody Integer id) {
        Employee employee = employeeService.selectByPrimaryKey(id);
        ResponseData<Employee> data = new ResponseData<>();
        data.setObject(employee);
        Response<Employee> response = new Response<>(0, "根据id查询员工", data);
        return response;
    }

    @RequestMapping("/deleteById")
    @RequirePermission({"删除员工信息","employee:delete"})
    public Response<Employee> deleteByPrimaryKey(@RequestBody Integer id) {
        int delete = employeeService.deleteByPrimaryKey(id);
        Response<Employee> response = new Response<>(0, "删除员工成功", null);
        return response;
    }

    @RequestMapping("/insert")
    @RequirePermission({"新增员工信息","employee:insert"})
    public Response<Employee> insert(@RequestBody Employee employee) {
        boolean insert = employeeService.insert(employee);
        if (insert) {
            Response<Employee> response = new Response<>(0, "添加员工成功", null);
            return response;
        }
        Response<Employee> response = new Response<>(1, "当前员工编号已存在，添加员工失败", null);
        return response;
    }

    @RequestMapping("/verifyInsert")
    @RequirePermission({"新增员工信息","employee:insert"})
    public Response<Employee> verifyInsert(@RequestBody User user) {
        boolean result = employeeService.verifyInsert(user.getLoginName());
        if (result){
            ResponseData<Employee> data = new ResponseData<>();
            data.setResult(result);
            data.setMessage("该登录名不存在");
            Response<Employee> response = new Response<>(0, "该登录名不存在", data);
            return response;
        }
        ResponseData<Employee> data = new ResponseData<>();
        data.setResult(result);
        data.setMessage("该登录名已存在");
        Response<Employee> response = new Response<>(0, "该登录名已存在", data);
        return response;
    }

    @RequestMapping("/selectAll")
    @RequirePermission({"查看员工信息","employee:select"})
    public Response<Employee> selectAll(@RequestBody QueryObject queryObject) {
        List<Employee> employees = employeeService.selectAll(queryObject);
        List<Department> departments = departmentService.selectAll(new QueryObject());
        ResponseData<Employee> data = new ResponseData<>();
        data.setList(employees);
        data.setListTwo(departments);
        Response<Employee> response = new Response<>(0, "查询员工", data);
        return response;
    }

    @RequestMapping("/updateById")
    @RequirePermission({"编辑员工信息","employee:edit"})
    public Response<Employee> updateByPrimaryKey(@RequestBody Employee employee) {
        boolean update = employeeService.updateByPrimaryKey(employee);
        if (update) {
            Response<Employee> response = new Response<>(0, "修改员工成功", null);
            return response;
        }
        Response<Employee> response = new Response<>(1, "当前员工编号已存在，修改员工失败", null);
        return response;
    }

    @RequestMapping("/deleteByIds")
    @RequirePermission({"删除员工信息","employee:delete"})
    public Response<Employee> deleteByIds(@RequestBody List<Integer> ids) {
        int delete = employeeService.deleteByIds(ids);
        Response<Employee> response = new Response<>(0, "批量删除员工成功", null);
        return response;
    }
}
