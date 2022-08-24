package com.arkarmoe.unittesting.controller;

import com.arkarmoe.unittesting.model.request.EmployeeRequest;
import com.arkarmoe.unittesting.model.response.BaseResponse;
import com.arkarmoe.unittesting.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("lists")
    public BaseResponse getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public BaseResponse registerEmployee(@RequestBody final EmployeeRequest request) {
        return employeeService.registerEmployee(request);
    }
}
