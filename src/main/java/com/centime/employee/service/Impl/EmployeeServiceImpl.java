package com.centime.employee.service.Impl;

import com.centime.employee.entity.Employee;
import com.centime.employee.exception.NoSuchServiceExistsException;
import com.centime.employee.repository.EmployeeRepository;
import com.centime.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Map<String, Object>> getAllEmployeeDetails(Integer id) {
        log.info("Entered: getAllEmployeeDetails|"+getClass().getName());
        try {
            List<Map<String, Object>> response = new ArrayList<>();
            List<Employee> employees = employeeRepository.findAll();
            Map<Integer, List<Employee>> employeeMap = employees.stream()
                    .collect(Collectors.groupingBy(Employee::getParentId));
            List<Map<String, Object>> result = organisationTreeMap(employeeMap, id);
            Optional<Employee> employeeOpt = employees.stream().filter(emp -> id.equals(emp.getId())).findAny();
            if (employeeOpt.isPresent()) {
                Employee employee = employeeOpt.get();
                responseMapping(response, employee, result);
            } else {
                response = result;
            }
            log.info("Exited: getAllEmployeeDetails|" + getClass().getName());
            return response;
        }catch (Exception ex){
            throw new NoSuchServiceExistsException("Something went wrong, we are checking");
        }
    }

    private List<Map<String, Object>> organisationTreeMap(Map<Integer, List<Employee>> employeeMap, Integer parentId) {
        log.info("Entered: organisationTreeMap|"+getClass().getName());
        List<Map<String, Object>> result = new ArrayList<>();
        if (employeeMap.containsKey(parentId)) {
            for (Employee emp : employeeMap.get(parentId)) {
                List<Map<String, Object>> innerMapList = organisationTreeMap(employeeMap, emp.getId());
                responseMapping(result, emp, innerMapList);
            }
        }
        log.info("Exited: organisationTreeMap|"+getClass().getName());
        return result;
    }

    private void responseMapping(List<Map<String, Object>> result, Employee emp, List<Map<String, Object>> innerMapList) {
        log.info("Entered: responseMapping|"+getClass().getName());
        Map<String, Object> map = new TreeMap<>();
        map.put("Name", emp.getName());
        if(!innerMapList.isEmpty()){
            map.put("Sub Classes", innerMapList);
        }
        result.add(map);
        log.info("Exited: responseMapping|"+getClass().getName());
    }
}
