package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    public EmployeeService employeeService;

    @PostMapping()
    // Build Add Employee REST API
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        // Call service create employee
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        // return response
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> employes = employeeService.getAllEmployee();

        return new ResponseEntity<>(employes,HttpStatus.ACCEPTED);
    }
}
