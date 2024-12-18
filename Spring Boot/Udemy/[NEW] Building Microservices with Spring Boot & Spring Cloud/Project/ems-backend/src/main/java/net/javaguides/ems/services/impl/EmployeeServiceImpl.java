package net.javaguides.ems.services.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.EmployeeRepository;
import net.javaguides.ems.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // this annotation tells Spring Container to create the spring bean for this class
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // convert Dto to Entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        // create data employee
        Employee savedEmployee = employeeRepository.save(employee);
        // covert to Dto from Entity
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

}
