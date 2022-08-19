package com.arkarmoe.unittesting.model.request;

import com.arkarmoe.unittesting.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String username;
    private String email;
    private String mobile;
    private Gender gender;

}
