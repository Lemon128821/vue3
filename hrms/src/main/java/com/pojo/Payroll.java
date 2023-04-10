package com.pojo;

import lombok.Data;

@Data
public class Payroll {
    //主键
    private Integer id;

    //薪资项目
    private String name;

    //开始日期
    private String startDate;

    //截止日期
    private String expirationDate;

}