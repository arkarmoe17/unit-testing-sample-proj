package com.arkarmoe.unittesting.controller;

import com.arkarmoe.unittesting.model.request.TodoRequest;
import com.arkarmoe.unittesting.model.response.BaseResponse;
import com.arkarmoe.unittesting.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/lists")
    public BaseResponse getAllTodos() {
        return todoService.fetchAllTodos();
    }

    @PostMapping()
    public BaseResponse createTodo(@RequestBody TodoRequest request) {
        return todoService.createTodo(request);
    }

    @PutMapping("/{id}")
    public BaseResponse updateTodo(@PathVariable("id") String id,
                                   @RequestBody TodoRequest request) {
        return todoService.updateTodo(id, request);

    }

//    @PutMapping("/{id}/assign")
//    public BaseResponse updateAssignee(@PathVariable("id") String id,
//                                       @RequestBody AssignTaskRequest request) {
//        return todoService.assignTodoTask(id, request);
//
//    }
}
