package com.arkarmoe.unittesting.service;

import com.arkarmoe.unittesting.model.request.UserRequest;
import com.arkarmoe.unittesting.model.response.BaseResponse;

public interface UserService {
    BaseResponse fetchAllUsers();
    BaseResponse createUser(UserRequest req);
    BaseResponse updateUser(Long id,UserRequest req);
    BaseResponse deleteUser(Long id);
}
