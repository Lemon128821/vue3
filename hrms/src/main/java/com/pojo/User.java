package com.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String loginName;

    private String password;

    private Integer empId;

    public User() {
    }

    public User(String loginName, String password, Integer empId) {
        this.loginName = loginName;
        this.password = password;
        this.empId = empId;
    }
}