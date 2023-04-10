package com.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SalaryReport {
    //主键
    private Integer id;

    //员工id
    private Integer empId;

    //薪资项目id
    private Integer payrollId;

    //基础工资
    private Double basicWage;

    //加班奖金
    private Double overtimePremium;

    //其他奖金
    private Double otherBonuses;

    //其他津贴
    private Double otherSubsidies;

    //其他加款
    private Double otherAdditions;

    //未出勤扣款
    private Double absenteeismDeductions;

    //病假扣款
    private Double sickLeaveDeductions;

    //其他扣款
    private Double otherDeductions;

    //养老保险
    private Double endowmentInsurance;

    //医疗保险
    private Double medicalInsurance;

    //失业保险
    private Double unemploymentInsurance;

    //公积金
    private Double accumulationFund;

    //个人所得税
    private Double individualIncomeTax;

    //员工
    private Employee employee;

    //薪资项目
    private Payroll payroll;

    //本月实发：monthlyWage
    public Double getMonthlyWage() {
        Double monthlyWage = basicWage+overtimePremium+otherBonuses+otherSubsidies+otherAdditions
                +absenteeismDeductions +sickLeaveDeductions+otherDeductions+endowmentInsurance+medicalInsurance
                +unemploymentInsurance +accumulationFund+individualIncomeTax;
        return monthlyWage;
    }
}