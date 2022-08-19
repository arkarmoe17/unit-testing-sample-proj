package com.arkarmoe.unittesting.user;

import com.arkarmoe.unittesting.model.entity.User;
import com.arkarmoe.unittesting.model.enums.Gender;
import com.arkarmoe.unittesting.model.request.UserRequest;
import com.arkarmoe.unittesting.repository.UserRepository;
import com.arkarmoe.unittesting.service.UserService;
import com.arkarmoe.unittesting.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.condition.JRE.JAVA_8;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("user service testcase")
public class UserServiceUnitTest {


    User user1 = new User(1L, "Mr.A", "Mr.A@gmail.com", "09972815566", Gender.MALE);
    User user2 = new User(2L, "Mr.B", "Mr_B@gmail.com", "09972815567", Gender.MALE);
    User user3 = new User(2L, "Ms.C", "Ms_C@gmail.com", "09972815568", Gender.FEMALE);

    @Mock
    private UserRepository userRepository;
    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;
    private UserService userService;

    @BeforeEach
    void init() {
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    @EnabledOnJre(JAVA_8)
    @DisplayName("test when Jre is ver-8")
    void onlyOnJava8() {
        System.out.println("testing java 8");
    }

    @Test
    @DisplayName("get all users")
    void getAllUsers() {
        userService.fetchAllUsers();
        verify(userRepository).findAll();
    }

    @ParameterizedTest
    @ValueSource(longs = {1})
    @DisplayName("find by id")
    @Disabled("just holding for testing.")
    void findByIdNotFound(Long id) {

    }

    @Test
    @DisplayName("create new user")
    void createNewUser() {
        UserRequest req = new UserRequest("Arkar", "arkar@gmail.com", "09972815566", Gender.MALE);
        userService.createUser(req);
        verify(userRepository, times(1)).save(ArgumentMatchers.any(User.class));
    }

    @Test
    @DisplayName("update user ")
    void updateUser() {
        UserRequest req = new UserRequest("Arkar", "arkar@gmail.com", "09972815566", Gender.MALE);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));
        userService.updateUser(1L, req);
        verify(userRepository, times(1)).save(user1);
    }

    @Test
    @DisplayName("delete user ")
    void deleteUser() {
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user1));
        userService.deleteUser(user1.getId());
        verify(userRepository, times(1)).delete(user1);
    }


}
