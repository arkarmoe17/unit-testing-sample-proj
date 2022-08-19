package com.arkarmoe.unittesting.controller;

import com.arkarmoe.unittesting.model.request.AssigneeRequest;
import com.arkarmoe.unittesting.model.response.BaseResponse;
import com.arkarmoe.unittesting.service.AssigneeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assignee")
@RequiredArgsConstructor
public class AssigneeController {
    private final AssigneeService assigneeService;

    @PostMapping
    public BaseResponse createAssignee(@RequestBody AssigneeRequest request) {
        return assigneeService.createAssignee(request);
    }
}
