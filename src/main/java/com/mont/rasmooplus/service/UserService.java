package com.mont.rasmooplus.service;

import com.mont.rasmooplus.dto.UserDto;
import com.mont.rasmooplus.model.jpa.User;

public interface UserService {
    User create(UserDto dto);

    Object sendRecoveryCode(String email);

}
