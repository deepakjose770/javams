package com.dipak.department.department.controller;

import com.dipak.department.department.entity.Department;
import com.dipak.department.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("saveDepartment : Inside method with data {}", department);
        return departmentService.saveDepartment(department);
    }


    @GetMapping("/{id}")
    public Department findDepartmentById(Long departmentId) {
        return departmentService.findDepartmentById(departmentId);
    }
}
