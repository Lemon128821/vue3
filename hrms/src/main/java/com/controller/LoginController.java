package com.controller;

import com.pojo.Employee;
import com.pojo.User;
import com.pojo.Response;
import com.pojo.ResponseData;
import com.service.EmployeeService;
import com.service.PermissionService;
import com.service.UserService;
import com.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public Response<Employee> login(@RequestBody User user) {
        User u = userService.selectByLoginName(user.getLoginName());
        if (u != null) {
            if (u.getPassword().equals(user.getPassword())) {
                Employee employee = employeeService.selectByPrimaryKey(u.getEmpId());
                List<String> expressions = null;
                if (employee != null) {
                    expressions = permissionService.selectExpressionByEmployeeId(employee.getId());
                }
                ResponseData<Employee> data = new ResponseData<>();
                String token = TokenUtils.token(u.getLoginName(), expressions);
                data.setToken(token);
                data.setObject(employee);
                data.setListTwo(expressions);
                Response<Employee> response = new Response<>(0, "登录成功", data);
                return response;
            } else {
                Response<Employee> response = new Response<>();
                response.setCode(1);
                response.setMessage("密码错误");
                return response;
            }

        } else {
            Response<Employee> response = new Response<>();
            response.setCode(1);
            response.setMessage("用户名不存在");
            return response;
        }
    }
}
