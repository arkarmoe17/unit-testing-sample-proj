package com.arkarmoe.unittesting.service.impl;

import com.arkarmoe.unittesting.model.entity.User;
import com.arkarmoe.unittesting.model.request.UserRequest;
import com.arkarmoe.unittesting.model.response.BaseResponse;
import com.arkarmoe.unittesting.repository.UserRepository;
import com.arkarmoe.unittesting.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public BaseResponse fetchAllUsers() {
        List<User> userList = userRepository.findAll();
        return new BaseResponse(0, userList, "Success");
    }

    @Override
    public BaseResponse createUser(UserRequest req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setMobile(req.getMobile());
        user.setGender(req.getGender());
        userRepository.save(user);
        return new BaseResponse(0, user, "Success");
    }

    @Override
    public BaseResponse updateUser(Long id, UserRequest req) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent())
            return new BaseResponse(1, null, "Id is not found.");
        User user = userOptional.get();
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setMobile(req.getMobile());
        user.setGender(req.getGender());
        userRepository.save(user);
        return new BaseResponse(0, user, "Success");
    }

    @Override
    public BaseResponse deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent())
            return new BaseResponse(1, null, "Id is not found.");
        userRepository.delete(userOptional.get());
        return new BaseResponse(0, null, "Success");
    }
}
