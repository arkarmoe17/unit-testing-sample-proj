package com.arkarmoe.unittesting.service.impl;

import com.arkarmoe.unittesting.model.entity.Account;
import com.arkarmoe.unittesting.model.entity.Employee;
import com.arkarmoe.unittesting.model.request.EmployeeRequest;
import com.arkarmoe.unittesting.model.response.BaseResponse;
import com.arkarmoe.unittesting.repository.EmployeeRepository;
import com.arkarmoe.unittesting.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public BaseResponse getAllEmployees() {
        List<Employee> employees =  employeeRepository.findAll();
        return new BaseResponse(0,employees,"Success.");
    }

    @Override
    public BaseResponse registerEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());

        Set<Account> accountList = new HashSet<>();
        for(String accId : request.getAccountIds()){
            accountList.add(new Account(accId,employee));
        }
        employee.setAccounts(accountList);
        employeeRepository.save(employee);
        return new BaseResponse(0,employee,"Success.");
    }
}
