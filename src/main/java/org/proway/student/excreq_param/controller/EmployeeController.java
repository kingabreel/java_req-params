package org.proway.student.excreq_param.controller;

import org.proway.student.excreq_param.model.Employee;
import org.proway.student.excreq_param.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployee(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) Double minSalary,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date hiredAfter,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date hiredBefore,
            @RequestParam(required = false) Integer active
    ) {

        return ResponseEntity.status(HttpStatus.OK).body(service.getEmployee(firstName, lastName, position, minSalary, hiredAfter, hiredBefore, active));
    }
}
