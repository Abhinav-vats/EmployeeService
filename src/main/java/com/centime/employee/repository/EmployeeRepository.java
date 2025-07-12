package com.centime.employee.repository;

import com.centime.employee.entity.Employee;
import com.centime.employee.vo.EmployeeVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM EMPLOYEE")
    List<EmployeeVo> findAllEmployees();

}
