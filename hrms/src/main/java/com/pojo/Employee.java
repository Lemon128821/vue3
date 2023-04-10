package com.pojo;

import lombok.Data;

@Data
public class Employee {
    //主键
    private Integer id;

    //姓名
    private String name;

    //员工编号
    private String empNum;

    //部门id
    private Integer deptId;

    //电话
    private String phone;

    //性别
    private Character gender;

    //电子邮箱
    private String email;

    private Department department;

    private String loginName;

    private String password;

}