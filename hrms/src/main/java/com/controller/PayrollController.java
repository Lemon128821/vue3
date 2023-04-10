package com.controller;

import com.pojo.Response;
import com.pojo.ResponseData;
import com.pojo.Payroll;
import com.service.PayrollService;
import com.util.RequirePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/payroll")
public class PayrollController {
    @Autowired
    private PayrollService payrollService;

    @RequestMapping("/deleteById")
    @RequirePermission({"删除薪资项目信息","payroll:delete"})
    public Response<Payroll> deleteByPrimaryKey(@RequestBody Integer id) {
        int delete = payrollService.deleteByPrimaryKey(id);
        Response<Payroll> response = new Response<>(0, "删除薪资项目成功", null);
        return response;
    }

    @RequestMapping("/deleteByIds")
    @RequirePermission({"删除薪资项目信息","payroll:delete"})
    public Response<Payroll> deleteByIds(@RequestBody int[] ids) {
        int delete = payrollService.deleteByIds(ids);
        Response<Payroll> response = new Response<>(0, "批量删除薪资项目成功", null);
        return response;
    }

    @RequestMapping("/insert")
    @RequirePermission({"新增薪资项目信息","payroll:insert"})
    public Response<Payroll> insert(@RequestBody Payroll payroll) {
        boolean insert = payrollService.insert(payroll);
        if (insert) {
            Response<Payroll> response = new Response<>(0, "添加薪资项目成功", null);
            return response;
        }
        Response<Payroll> response = new Response<>(1, "当前薪资项目已存在，添加薪资项目失败", null);
        return response;
    }

    @RequestMapping("/selectById")
    @RequirePermission({"编辑薪资项目信息","payroll:edit"})
    public Response<Payroll> selectByPrimaryKey(@RequestBody Integer id) {
        Payroll payroll = payrollService.selectByPrimaryKey(id);
        ResponseData<Payroll> data = new ResponseData<>();
        data.setObject(payroll);
        Response<Payroll> response = new Response<>(0, "根据id查询薪资项目", data);
        return response;
    }

    @RequestMapping("/selectAll")
    @RequirePermission({"查看薪资项目信息","payroll:select"})
    public Response<Payroll> selectAll() {
        List<Payroll> payrolls = payrollService.selectAll();
        ResponseData<Payroll> data = new ResponseData<>();
        data.setList(payrolls);
        Response<Payroll> response = new Response<>(0, "查询薪资项目", data);
        return response;
    }

    @RequestMapping("/updateById")
    @RequirePermission({"编辑薪资项目信息","payroll:edit"})
    public Response<Payroll> updateByPrimaryKey(@RequestBody Payroll payroll) {
        boolean update = payrollService.updateByPrimaryKey(payroll);
        if (update) {
            Response<Payroll> response = new Response<>(0, "修改薪资项目成功", null);
            return response;
        }
        Response<Payroll> response = new Response<>(1, "当前薪资项目已存在，修改薪资项目失败", null);
        return response;
    }
}
