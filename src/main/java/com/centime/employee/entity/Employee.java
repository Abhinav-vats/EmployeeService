package com.centime.employee.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    private Integer id;

    @Column(name = "parentid")
    private Integer parentId;

    @Column
    private String name;

    @Column
    private String color;

}
