package com.arkarmoe.unittesting.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TodoRequest {
    String task;
    boolean isFinished;
}
