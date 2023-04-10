package com.mapper;

import com.pojo.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByEmpId(Integer empId);

    int insert(User user);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User user);

    User selectByLoginName(String loginName);

    String selectLoginNameByEmpId(Integer empId);

    String selectPasswordByEmpId(Integer empId);

    int updatePasswordByEmpId(User user);


}