package com.mont.rasmooplus.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mont.rasmooplus.model.jpa.UserType;
import com.mont.rasmooplus.repository.jpa.UserTypeRepository;
import com.mont.rasmooplus.service.impl.UserTypeServiceImpl;

@ExtendWith(MockitoExtension.class)
class UserTypeServiceTest {
    @Mock    
    private UserTypeRepository userTypeRepository;

    @InjectMocks
    private UserTypeServiceImpl userTypeService;

    @Test
    void findAll() {
        List<UserType> userTypeList = new ArrayList<>();
        
        var userType1 = new UserType(1L, "Professor", "Professor da plataforma");
        var userType2 = new UserType(2L, "Administrador", "Administrador da plataforma");
        
        userTypeList.addAll(Arrays.asList(userType1, userType2));
        Mockito.when(userTypeRepository.findAll()).thenReturn(userTypeList);

       Assertions.assertThat(userTypeService.findAll()).isNotEmpty(); 
    }

}
