package com.devfromdust.employee_management_system.Dto;

import com.devfromdust.employee_management_system.Entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapEmployeeToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapEmployeeDtoToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
