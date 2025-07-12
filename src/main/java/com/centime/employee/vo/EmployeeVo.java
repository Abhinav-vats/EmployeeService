package com.centime.employee.vo;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class EmployeeVo implements Serializable {

    private static final long serialVersionUID = 8548405224153406589L;

    private Integer id;

    private Integer parentId;

    private String name;

    private String color;

}
