package com.service.impl;

import com.mapper.PayrollMapper;
import com.mapper.SalaryReportMapper;
import com.pojo.Payroll;
import com.service.PayrollService;
import com.service.SalaryReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {
    @Autowired
    private PayrollMapper payrollMapper;

    @Autowired
    private SalaryReportMapper salaryReportMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int delete = payrollMapper.deleteByPrimaryKey(id);
        salaryReportMapper.deleteByPayrollId(id);
        return delete;
    }

    @Override
    public boolean insert(Payroll payroll) {
        Payroll p = payrollMapper.selectByName(payroll.getName());
        if (p == null) {
            payrollMapper.insert(payroll);
            return true;
        }
        return false;
    }

    @Override
    public Payroll selectByPrimaryKey(Integer id) {
        Payroll payroll = payrollMapper.selectByPrimaryKey(id);
        return payroll;
    }

    @Override
    public List<Payroll> selectAll() {
        List<Payroll> payrolls = payrollMapper.selectAll();
        return payrolls;
    }

    @Override
    public boolean updateByPrimaryKey(Payroll payroll) {
        Payroll p = payrollMapper.selectByName(payroll.getName());
        if (p == null) {
            payrollMapper.updateByPrimaryKey(payroll);
            return true;
        } else {
            Payroll selectByPrimaryKey = payrollMapper.selectByPrimaryKey(payroll.getId());
            if (selectByPrimaryKey.getName().equals(payroll.getName())) {
                payrollMapper.updateByPrimaryKey(payroll);
                return true;
            }
        }
        return false;
    }

    @Override
    public int deleteByIds(int[] ids) {
        int delete = payrollMapper.deleteByIds(ids);
        salaryReportMapper.deleteByPayrollIds(ids);
        return delete;
    }
}
