package com.controller;

import com.pojo.QueryObject;
import com.pojo.Response;
import com.pojo.ResponseData;
import com.pojo.Role;
import com.service.RoleService;
import com.util.RequirePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/selectAll")
    @RequirePermission({"查看角色信息","role:select"})
    public Response<Role> selectAll(@RequestBody QueryObject queryObject) {
        List<Role> roles = roleService.selectAll(queryObject);
        ResponseData<Role> data = new ResponseData<>();
        data.setList(roles);
        Response<Role> response = new Response<>(0, "查询角色", data);
        return response;
    }

    @RequestMapping("/deleteById")
    @RequirePermission({"删除角色信息","role:delete"})
    public Response<Role> deleteByPrimaryKey(@RequestBody Integer id) {
        int delete = roleService.deleteByPrimaryKey(id);
        Response<Role> response = new Response<>(0, "删除角色成功", null);
        return response;
    }

    @RequestMapping("/insert")
    @RequirePermission({"新增角色信息","role:insert"})
    public Response<Role> insert(@RequestBody Role role) {
        boolean insert = roleService.insert(role);
        if (insert) {
            Response<Role> response = new Response<>(0, "添加角色成功", null);
            return response;
        }
        Response<Role> response = new Response<>(1, "当前角色已存在，添加角色失败", null);
        return response;
    }

    @RequestMapping("/selectById")
    @RequirePermission({"编辑角色信息","role:edit"})
    public Response<Role> selectByPrimaryKey(@RequestBody Integer id) {
        Role role = roleService.selectByPrimaryKey(id);
        ResponseData<Role> data = new ResponseData<>();
        data.setObject(role);
        Response<Role> response = new Response<>(0, "根据id查询角色", data);
        return response;
    }

    @RequestMapping("/updateById")
    @RequirePermission({"编辑角色信息","role:edit"})
    public Response<Role> updateByPrimaryKey(@RequestBody Role role) {
        boolean update = roleService.updateByPrimaryKey(role);
        if (update) {
            Response<Role> response = new Response<>(0, "修改角色成功", null);
            return response;
        }
        Response<Role> response = new Response<>(1, "当前角色已存在，修改角色失败", null);
        return response;
    }

    @RequestMapping("/deleteByIds")
    @RequirePermission({"删除角色信息","role:delete"})
    public Response<Role> deleteByIds(@RequestBody List<Integer> ids) {
        int delete = roleService.deleteByIds(ids);
        Response<Role> response = new Response<>(0, "批量删除角色成功", null);
        return response;
    }

    @RequestMapping("/selectByEmployeeId")
    @RequirePermission({"给员工分配角色","employee:allotRole"})
    public Response<Role> selectByEmployeeId(@RequestBody Integer employeeId) {
        List<Integer> roleIds = roleService.selectByEmployeeId(employeeId);
        List<Role> roles = roleService.selectAll(new QueryObject());
        ResponseData<Role> data = new ResponseData<>();
        data.setListTwo(roleIds);
        data.setList(roles);
        Response<Role> response = new Response<>(0, "根据员工id查询角色", data);
        return response;
    }

    @RequestMapping("/allotRole")
    @RequirePermission({"给员工分配角色","employee:allotRole"})
    public Response<Role> allotRole(@RequestBody QueryObject queryObject) {
        int allotRole = roleService.allotRole(queryObject);
        Response<Role> response = new Response<>(0, "分配角色成功", null);
        return response;
    }
}
