package com.arkarmoe.unittesting.user;

import com.arkarmoe.unittesting.repository.UserRepository;
import com.arkarmoe.unittesting.service.UserService;
import com.arkarmoe.unittesting.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void init() {
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void getAllUsers() {
        userService.fetchAllUsers();
        verify(userRepository).findAll();
    }
}
