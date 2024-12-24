package net.javaguides.department_service.controller;

import lombok.AllArgsConstructor;
import net.javaguides.department_service.dto.DepartmentDto;
import net.javaguides.department_service.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    // REST API: save department
    @PostMapping("/department")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment =departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

}
