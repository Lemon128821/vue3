package com.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Department {
    private Integer id;

    private String name;

    private Integer parentId;

    private Integer leaderId;

    private String status;

    private String modnDate;

    private Department department;

    private List<Department> departments;

    private String leader;
}