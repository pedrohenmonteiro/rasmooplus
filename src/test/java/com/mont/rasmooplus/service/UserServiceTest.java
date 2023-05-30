package com.mont.rasmooplus.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mont.rasmooplus.dto.UserDto;
import com.mont.rasmooplus.model.jpa.User;
import com.mont.rasmooplus.model.jpa.UserType;
import com.mont.rasmooplus.repository.jpa.UserRepository;
import com.mont.rasmooplus.repository.jpa.UserTypeRepository;
import com.mont.rasmooplus.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserTypeRepository userTypeRepository;

    @InjectMocks
    private UserServiceImpl userService;

    
    @Test
    void given_create_when_idIsNotNullAndUserisFound_then_return_UserCreated() {

        UserDto dto = new UserDto();
        dto.setEmail("pedro@email.com");
        dto.setCpf("11111111111");
        dto.setUserTypeId(1L);

        UserType userType = new UserType(1L, "Aluno", "Aluno da plataforma");
        when(userTypeRepository.findById(1L)).thenReturn(Optional.of(userType));

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setCpf(dto.getCpf());
        user.setDtSubscription(dto.getDtSubscription());
        user.setDtExpiration(dto.getDtExpiration());
        user.setUserType(userType);
        when(userRepository.save(user)).thenReturn(user);


        Assertions.assertEquals(user,userService.create(dto));

    }
}
