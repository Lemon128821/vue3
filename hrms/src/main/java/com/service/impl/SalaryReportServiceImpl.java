package com.service.impl;

import com.mapper.SalaryReportMapper;
import com.pojo.QueryObject;
import com.pojo.SalaryReport;
import com.service.SalaryReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryReportServiceImpl implements SalaryReportService {
    @Autowired
    private SalaryReportMapper salaryReportMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int delete = salaryReportMapper.deleteByPrimaryKey(id);
        return delete;
    }

    @Override
    public boolean insert(SalaryReport salaryReport) {
        SalaryReport selectByEmpIdAndPayrollId = salaryReportMapper.selectByEmpIdAndPayrollId(salaryReport);
        if (selectByEmpIdAndPayrollId == null) {
            salaryReportMapper.insert(salaryReport);
            return true;
        }
        return false;
    }

    @Override
    public SalaryReport selectByPrimaryKey(Integer id) {
        SalaryReport salaryReport = salaryReportMapper.selectByPrimaryKey(id);
        return salaryReport;
    }

    @Override
    public List<SalaryReport> selectAll(QueryObject queryObject) {
        List<SalaryReport> salaryReports = salaryReportMapper.selectAll(queryObject);
        return salaryReports;
    }

    @Override
    public boolean updateByPrimaryKey(SalaryReport salaryReport) {
        SalaryReport selectByEmpIdAndPayrollId = salaryReportMapper.selectByEmpIdAndPayrollId(salaryReport);
        if (selectByEmpIdAndPayrollId == null) {
            salaryReportMapper.updateByPrimaryKey(salaryReport);
            return true;
        } else {
            SalaryReport selectByPrimaryKey = salaryReportMapper.selectByPrimaryKey(salaryReport.getId());
            if (selectByPrimaryKey.getEmpId() == salaryReport.getEmpId()
                    && selectByPrimaryKey.getPayrollId() == salaryReport.getPayrollId()) {
                salaryReportMapper.updateByPrimaryKey(salaryReport);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<SalaryReport> selectByPayrollId(Integer payrollId) {
        List<SalaryReport> salaryReports = salaryReportMapper.selectByPayrollId(payrollId);
        return salaryReports;
    }

    @Override
    public int deleteByIds(int[] ids) {
        int delete = salaryReportMapper.deleteByIds(ids);
        return delete;
    }
}
