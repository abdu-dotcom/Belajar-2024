package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080/api/departments", value = "DEPARTMENT-SERVICE")
public interface APIClient {
    // REST API: get a employee
    @GetMapping("/department/{department-code}")
    DepartmentDto getDepartement(@PathVariable("department-code") String departmentCode);
}
