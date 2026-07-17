package com.devfromdust.employee_management_system.Service;

import com.devfromdust.employee_management_system.Dto.EmployeeDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

EmployeeDto createEmployee(EmployeeDto employeeDto);

EmployeeDto getEmployeeById(Long employeeId);

List<EmployeeDto> getAllEmployee();

EmployeeDto updateEmployee(Long employeeId,EmployeeDto employeeDto);

void deleteEmployee(Long employeeId);
}
