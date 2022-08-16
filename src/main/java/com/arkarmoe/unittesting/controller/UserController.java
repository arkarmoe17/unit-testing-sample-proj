package com.arkarmoe.unittesting.controller;

import com.arkarmoe.unittesting.model.request.UserRequest;
import com.arkarmoe.unittesting.model.response.BaseResponse;
import com.arkarmoe.unittesting.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    //list
    @GetMapping("/lists")
    public BaseResponse fetchAllUserLists() {
        return userService.fetchAllUsers();
    }

    //create
    @PostMapping("/new")
    public BaseResponse createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    //update
    @PutMapping("/{id}")
    public BaseResponse updateUser(@PathVariable("id") Long id,
                                   @RequestBody UserRequest userRequest) {
        return userService.updateUser(id, userRequest);
    }

    //delete
    @DeleteMapping("/{id}")
    public BaseResponse deleteUser(@PathVariable("id")Long id){
        return userService.deleteUser(id);
    }
}
