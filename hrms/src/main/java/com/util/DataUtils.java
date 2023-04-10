package com.util;

import com.pojo.Department;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {
    public static List<Integer> ids = new ArrayList<>();

    public static List<Integer> getChildrenDepartmentIds(List<Department> departments) {
        if (departments != null) {
            for (Department department : departments) {
                ids.add(department.getId());
                if (department.getDepartments() != null) {
                    getChildrenDepartmentIds(department.getDepartments());
                }
            }
        }
        return ids;
    }
}
