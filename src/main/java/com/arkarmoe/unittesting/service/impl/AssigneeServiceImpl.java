package com.arkarmoe.unittesting.service.impl;

import com.arkarmoe.unittesting.model.entity.Assignee;
import com.arkarmoe.unittesting.model.request.AssigneeRequest;
import com.arkarmoe.unittesting.model.response.BaseResponse;
import com.arkarmoe.unittesting.repository.AssigneeRepository;
import com.arkarmoe.unittesting.service.AssigneeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssigneeServiceImpl implements AssigneeService {
    private final AssigneeRepository assigneeRepository;

    @Override
    public BaseResponse createAssignee(AssigneeRequest request) {
        Assignee assignee = Assignee.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .build();
        assigneeRepository.save(assignee);
        return new BaseResponse(0,assignee,"Success.");
    }
}
