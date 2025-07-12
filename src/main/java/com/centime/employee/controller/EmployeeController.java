package com.centime.employee.controller;


import com.centime.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping("/check")
    public String healthCheck(){
        log.info("Entered: healthCheck|"+getClass().getName());
        log.info("Exited: healthCheck|"+getClass().getName());
        return "UP";
    }

    @GetMapping("/relation")
    public ResponseEntity<List<Map<String, Object>>> fetchEmployeeDetails(@RequestParam(value = "id", required = false) String idStr){
        log.info("Entered: fetchEmployeeDetails|"+getClass().getName());
        Integer id = idStr!=null?Integer.parseInt(idStr): 0;
        List<Map<String, Object>> response = employeeService.getAllEmployeeDetails(id);
        log.info("Exited: fetchEmployeeDetails|"+getClass().getName());
        return ResponseEntity.ok(response);
    }
}
