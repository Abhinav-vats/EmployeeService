package com.centime.employee.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Sub Classes")
    private List<EmployeeDto> subClasses;
}
