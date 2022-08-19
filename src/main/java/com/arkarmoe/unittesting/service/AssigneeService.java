package com.arkarmoe.unittesting.service;

import com.arkarmoe.unittesting.model.request.AssigneeRequest;
import com.arkarmoe.unittesting.model.response.BaseResponse;

public interface AssigneeService {
    BaseResponse createAssignee(AssigneeRequest request);
}
