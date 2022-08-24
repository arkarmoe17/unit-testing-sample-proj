package com.arkarmoe.unittesting.model.request;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private String email;
    private List<String> accountIds;
}
