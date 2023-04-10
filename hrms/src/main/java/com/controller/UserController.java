package com.controller;


import com.pojo.ResponseData;
import com.pojo.User;
import com.pojo.Response;
import com.service.UserService;
import com.util.RequirePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/verifyPassword")
    @RequirePermission({"编辑当前登录用户的密码","user:editPassword"})
    public Response<User> verifyPassword(@RequestBody User user) {
        boolean result = userService.verifyPassword(user);
        if (result){
            ResponseData<User> data = new ResponseData<>();
            data.setResult(result);
            data.setMessage("原密码正确");
            Response<User> response = new Response<>(0, "原密码正确", data);
            return response;
        }
        ResponseData<User> data = new ResponseData<>();
        data.setResult(result);
        data.setMessage("原密码不正确");
        Response<User> response = new Response<>(0, "原密码不正确", data);
        return response;
    }

    @RequestMapping("/updatePassword")
    @RequirePermission({"编辑当前登录用户的密码","user:editPassword"})
    public Response<User> updatePassword(@RequestBody User user) {
        int update = userService.updatePassword(user);
        Response<User> response = new Response<>(0, "修改密码成功", null);
        return response;
    }

}
