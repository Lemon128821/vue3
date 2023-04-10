package com.controller;

import com.pojo.*;
import com.service.PermissionService;
import com.util.RequirePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/selectAll")
    @RequirePermission({"查看权限信息","permission:select"})
    public Response<Permission> selectAll(@RequestBody QueryObject queryObject) {
        List<Permission> permissions = permissionService.selectAll(queryObject);
        ResponseData<Permission> data = new ResponseData<>();
        data.setList(permissions);
        Response<Permission> response = new Response<>(0, "查询权限", data);
        return response;
    }

    @RequestMapping("/selectByRoleId")
    @RequirePermission({"给角色分配权限","role:allotPermission"})
    public Response<Permission> selectByRoleId(@RequestBody Integer roleId) {
        List<Integer> permissionIds = permissionService.selectByRoleId(roleId);
        List<Permission> permissions = permissionService.selectAll(new QueryObject());
        ResponseData<Permission> data = new ResponseData<>();
        data.setList(permissions);
        data.setListTwo(permissionIds);
        Response<Permission> response = new Response<>(0, "根据角色id查询权限", data);
        return response;
    }

    @RequestMapping("/allotPermission")
    @RequirePermission({"给角色分配权限","role:allotPermission"})
    public Response<Role> allotPermission(@RequestBody QueryObject queryObject) {
        int allotPermission = permissionService.allotPermission(queryObject);
        Response<Role> response = new Response<>(0, "分配权限成功", null);
        return response;
    }

}
