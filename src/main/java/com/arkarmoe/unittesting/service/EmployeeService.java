package com.arkarmoe.unittesting.service;

import com.arkarmoe.unittesting.model.request.EmployeeRequest;
import com.arkarmoe.unittesting.model.response.BaseResponse;

public interface EmployeeService {
    BaseResponse getAllEmployees();
    BaseResponse registerEmployee(EmployeeRequest request);
}
