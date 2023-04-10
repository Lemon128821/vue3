package com.service.impl;

import com.mapper.*;
import com.pojo.Department;
import com.pojo.QueryObject;
import com.service.DepartmentService;
import com.util.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SalaryReportMapper salaryReportMapper;

    @Autowired
    private EmployeeRoleMapper employeeRoleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        List<Department> departments = departmentMapper.selectByPId(id);
        if (DataUtils.ids != null || DataUtils.ids.size() > 0) {
            DataUtils.ids.clear();
        }
        List<Integer> ids = DataUtils.getChildrenDepartmentIds(departments);
        ids.add(id);
        List<Integer> empIds = employeeMapper.selectByDeptIds(ids);
        for (Integer empId : empIds) {
            employeeRoleMapper.deleteByEmployeeId(empId);
            userMapper.deleteByEmpId(empId);
            salaryReportMapper.deleteByEmpId(empId);
        }
        employeeMapper.deleteByDeptIds(ids);
        int delete = departmentMapper.deleteByIds(ids);
        return delete;
    }

    @Override
    public boolean insert(Department department) {
        Department selectByName = departmentMapper.selectByName(department.getName());
        if (selectByName == null) {
            departmentMapper.insert(department);
            return true;
        }
        return false;
    }

    @Override
    public Department selectByPrimaryKey(Integer id) {
        Department department = departmentMapper.selectByPrimaryKey(id);
        return department;
    }

    @Override
    public List<Department> selectAll(QueryObject queryObject) {
        List<Department> departments = departmentMapper.selectAll(queryObject);
        return departments;
    }

    @Override
    public List<Department> selectByFirst() {
        List<Department> departments = departmentMapper.selectByFirst();
        return departments;
    }

    @Override
    public boolean updateByPrimaryKey(Department department) {
        Department selectByName = departmentMapper.selectByName(department.getName());
        if (selectByName == null) {
            departmentMapper.updateByPrimaryKey(department);
            return true;
        } else {
            Department selectByPrimaryKey = departmentMapper.selectByPrimaryKey(department.getId());
            if (selectByPrimaryKey.getName().equals(department.getName())) {
                departmentMapper.updateByPrimaryKey(department);
                return true;
            }
        }
        return false;
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        int delete = 0;
        for (Integer id : ids) {
            delete += deleteByPrimaryKey(id);
        }
        return delete;
    }

    @Override
    public List<Department> selectOptionalParentDepartment(Integer id) {
        List<Department> departments = departmentMapper.selectByPId(id);
        if (DataUtils.ids != null || DataUtils.ids.size() > 0) {
            DataUtils.ids.clear();
        }
        List<Integer> ids = DataUtils.getChildrenDepartmentIds(departments);
        ids.add(id);
        List<Department> list = departmentMapper.selectOptionalParentDepartment(ids);
        return list;
    }
}
