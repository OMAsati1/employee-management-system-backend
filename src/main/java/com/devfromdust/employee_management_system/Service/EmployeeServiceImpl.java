
package com.devfromdust.employee_management_system.Service;

import com.devfromdust.employee_management_system.Dto.EmployeeDto;
import com.devfromdust.employee_management_system.Dto.EmployeeMapper;
import com.devfromdust.employee_management_system.Exception.ResourceNotFoundException;
import com.devfromdust.employee_management_system.Repository.EmployeeRepo;
import com.devfromdust.employee_management_system.Entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.devfromdust.employee_management_system.Exception.DuplicateEmailException;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service

public class EmployeeServiceImpl implements EmployeeService{
        EmployeeRepo employeeRepo;

        @Override
        public EmployeeDto createEmployee(EmployeeDto employeeDto) {
            Employee employee = EmployeeMapper.mapEmployeeDtoToEmployee(employeeDto);
            try {
                Employee savedEmployee = employeeRepo.save(employee);
                return EmployeeMapper.mapEmployeeToEmployeeDto(savedEmployee);
            }
            catch (DataIntegrityViolationException e) {
                throw new DuplicateEmailException("Duplicate email is not allowed.");
            }
        }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(()->new
                ResourceNotFoundException("Employee not found with id " + employeeId));
        return EmployeeMapper.mapEmployeeToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map(employee -> EmployeeMapper.mapEmployeeToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee not found with id " + employeeId));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        try {
            employeeRepo.save(employee);
        }
        catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException("Duplicate email is not allowed.");
        }

        return EmployeeMapper.mapEmployeeToEmployeeDto(employee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee not found with id " + employeeId));
        employeeRepo.delete(employee);
    }
}



