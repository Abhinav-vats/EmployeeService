package com.centime.employee.service;

import com.centime.employee.entity.Employee;
import com.centime.employee.vo.EmployeeVo;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Map<String, Object>> getAllEmployeeDetails(Integer id);
}
