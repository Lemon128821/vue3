package com.controller;

import com.pojo.*;
import com.service.DepartmentService;
import com.service.EmployeeService;
import com.util.RequirePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/selectAll")
    @RequirePermission({"查看部门信息","department:select"})
    public Response<Department> selectAll(@RequestBody QueryObject queryObject) {
        List<Department> departments = departmentService.selectAll(queryObject);
        List<Department> selectByFirst = departmentService.selectByFirst();
        List<Employee> employees = employeeService.selectAll(new QueryObject());
        ResponseData<Department> data = new ResponseData<>();
        data.setList(departments);
        data.setListTwo(selectByFirst);
        data.setListThree(employees);
        Response<Department> response = new Response<>(0, "查询部门", data);
        return response;
    }

    @RequestMapping("/deleteById")
    @RequirePermission({"删除部门信息","department:delete"})
    public Response<Department> deleteByPrimaryKey(@RequestBody Integer id) {
        int delete = departmentService.deleteByPrimaryKey(id);
        Response<Department> response = new Response<>(0, "删除部门成功", null);
        return response;
    }

    @RequestMapping("/insert")
    @RequirePermission({"新增部门信息","department:insert"})
    public Response<Department> insert(@RequestBody Department department) {
        boolean insert = departmentService.insert(department);
        if (insert) {
            Response<Department> response = new Response<>(0, "添加部门成功", null);
            return response;
        }
        Response<Department> response = new Response<>(1, "当前部门已存在，添加部门失败", null);
        return response;
    }

    @RequestMapping("/selectById")
    @RequirePermission({"编辑部门信息","department:edit"})
    public Response<Department> selectByPrimaryKey(@RequestBody Integer id) {
        Department department = departmentService.selectByPrimaryKey(id);
        ResponseData<Department> data = new ResponseData<>();
        data.setObject(department);
        Response<Department> response = new Response<>(0, "根据id查询部门", data);
        return response;
    }

    @RequestMapping("/selectOptionalParentDepartment")
    @RequirePermission({"编辑部门信息","department:edit"})
    public Response<Department> selectOptionalParentDepartment(@RequestBody Integer id) {
        List<Department> departments = departmentService.selectOptionalParentDepartment(id);
        ResponseData<Department> data = new ResponseData<>();
        data.setList(departments);
        Response<Department> response = new Response<>(0, "查询可选的上级部门", data);
        return response;
    }

    @RequestMapping("/updateById")
    @RequirePermission({"编辑部门信息","department:edit"})
    public Response<Department> updateByPrimaryKey(@RequestBody Department department) {
        boolean update = departmentService.updateByPrimaryKey(department);
        if (update) {
            Response<Department> response = new Response<>(0, "修改部门成功", null);
            return response;
        }
        Response<Department> response = new Response<>(1, "当前部门已存在，修改部门失败", null);
        return response;
    }

    @RequestMapping("/deleteByIds")
    @RequirePermission({"删除部门信息","department:delete"})
    public Response<Department> deleteByIds(@RequestBody List<Integer> ids) {
        int delete = departmentService.deleteByIds(ids);
        Response<Department> response = new Response<>(0, "批量删除部门成功", null);
        return response;
    }
}
