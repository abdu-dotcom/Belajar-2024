package net.javaguides.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.mapper.EmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

    Employee employee = EmployeeMapper.INSTANCE.employeeDtoToEmployee(employeeDto);
    Employee savedEmployee = employeeRepository.save(employee);

    return EmployeeMapper.INSTANCE.employeeToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).get();

        System.out.println("employee getFirstName : " +  employee.getFirstName());
        System.out.println("employee getLastName : " +  employee.getLastName());
        System.out.println("employee getEmail: " +  employee.getEmail());

    return EmployeeMapper.INSTANCE.employeeToEmployeeDto(employee);
    }
}
