package com.arkarmoe.unittesting.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    private int errorStatus;
    private Object data;
    private String message;
}
