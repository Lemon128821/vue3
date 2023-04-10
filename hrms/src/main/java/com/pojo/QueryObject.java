package com.pojo;

import lombok.Data;

import java.util.List;

@Data
public class QueryObject {

    private String name;

    private Integer payrollId;

    private Integer employeeId;

    private List<Integer> roleIds;

    private Integer roleId;

    private List<Integer> permissionIds;

}
