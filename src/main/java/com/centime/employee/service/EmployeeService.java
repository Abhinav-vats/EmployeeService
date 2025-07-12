package com.centime.employee.service;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Map<String, Object>> getAllEmployeeDetails(Integer id);
}
