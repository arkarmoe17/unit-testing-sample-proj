package com.arkarmoe.unittesting.service;

import com.arkarmoe.unittesting.model.request.TodoRequest;
import com.arkarmoe.unittesting.model.response.BaseResponse;

public interface TodoService {
    BaseResponse fetchAllTodos();

    BaseResponse createTodo(TodoRequest request);

    BaseResponse updateTodo(String id, TodoRequest request);
}
