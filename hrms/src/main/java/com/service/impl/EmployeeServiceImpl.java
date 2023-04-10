package com.service.impl;

import com.mapper.EmployeeMapper;
import com.mapper.EmployeeRoleMapper;
import com.mapper.SalaryReportMapper;
import com.mapper.UserMapper;
import com.pojo.Employee;
import com.pojo.QueryObject;
import com.pojo.User;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRoleMapper employeeRoleMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SalaryReportMapper salaryReportMapper;

    @Override
    public Employee selectByPrimaryKey(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int delete = employeeMapper.deleteByPrimaryKey(id);
        employeeRoleMapper.deleteByEmployeeId(id);
        userMapper.deleteByEmpId(id);
        salaryReportMapper.deleteByEmpId(id);
        return delete;
    }

    @Override
    public boolean insert(Employee employee) {
        Employee selectByEmpNum = employeeMapper.selectByEmpNum(employee.getEmpNum());
        if (selectByEmpNum == null) {
            employeeMapper.insert(employee);
            userMapper.insert(new User(employee.getLoginName(), employee.getPassword(), employee.getId()));
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> selectAll(QueryObject queryObject) {
        List<Employee> employees = employeeMapper.selectAll(queryObject);
        return employees;
    }

    @Override
    public boolean updateByPrimaryKey(Employee employee) {
        Employee selectByEmpNum = employeeMapper.selectByEmpNum(employee.getEmpNum());
        if (selectByEmpNum == null) {
            employeeMapper.updateByPrimaryKey(employee);
            return true;
        } else {
            Employee selectByPrimaryKey = employeeMapper.selectByPrimaryKey(employee.getId());
            if (selectByPrimaryKey.getEmpNum().equals(employee.getEmpNum())) {
                employeeMapper.updateByPrimaryKey(employee);
                return true;
            }
        }
        return false;
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        int delete = employeeMapper.deleteByIds(ids);
        for (Integer id : ids) {
            employeeRoleMapper.deleteByEmployeeId(id);
            userMapper.deleteByEmpId(id);
            salaryReportMapper.deleteByEmpId(id);
        }
        return delete;
    }

    @Override
    public boolean verifyInsert(String loginName) {
        User user = userMapper.selectByLoginName(loginName);
        if (user == null) {
            return true;
        }
        return false;
    }
}
