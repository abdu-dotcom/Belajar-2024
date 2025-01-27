package net.javaguides.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.exception.ResourceNotFoundException;
import net.javaguides.employeeservice.mapper.EmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.APIClient;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    // private RestTemplate restTemplate;
    // private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.INSTANCE.employeeDtoToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.INSTANCE.employeeToEmployeeDto(savedEmployee);
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

        Employee employee =
            employeeRepository
                .findById(employeeId)
                .orElseThrow(
                    () -> new ResourceNotFoundException("Employee", "employeeId", employeeId));

        System.out.println("employee: " + employee.getId());
        System.out.println("employee: " + employee.getFirstName());
        System.out.println("employee: " + employee.getLastName());
        System.out.println("employee: " + employee.getEmail());
        System.out.println("employee" +
                ": " + employee.getDepartmentCode());

        DepartmentDto departmentDto = apiClient.getDepartement(employee.getDepartmentCode());

        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.employeeToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
      }
}
