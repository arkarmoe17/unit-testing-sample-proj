package com.arkarmoe.unittesting.service.impl;

import com.arkarmoe.unittesting.model.entity.Todo;
import com.arkarmoe.unittesting.model.request.TodoRequest;
import com.arkarmoe.unittesting.model.response.BaseResponse;
import com.arkarmoe.unittesting.repository.AssigneeRepository;
import com.arkarmoe.unittesting.repository.TodoRepository;
import com.arkarmoe.unittesting.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    private final AssigneeRepository assigneeRepository;

    @Override
    public BaseResponse fetchAllTodos() {
        List<Todo> todoList = todoRepository.findAll();
        return new BaseResponse(0, todoList, "Success.");
    }

    @Override
    public BaseResponse createTodo(TodoRequest request) {
        Todo todo = Todo.builder()
                .task(request.getTask())
                .isFinished(request.isFinished())
                .build();
        System.out.println("todo:" + todo.toString());
        todoRepository.save(todo);
        return new BaseResponse(0, todo, "Success.");
    }

    @Override
    public BaseResponse updateTodo(String id, TodoRequest request) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (!todoOptional.isPresent())
            return new BaseResponse(1, null, "Id is not found.");
        Todo todo = todoOptional.get();
        todo.setTask(request.getTask());
        todo.setFinished(request.isFinished());
        todoRepository.save(todo);
        return new BaseResponse(0, todo, "Success.");
    }


}
