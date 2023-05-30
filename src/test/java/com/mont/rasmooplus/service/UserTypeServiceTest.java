package com.mont.rasmooplus.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mont.rasmooplus.model.jpa.UserType;

@SpringBootTest
class UserTypeServiceTest {
    
    @MockBean
    private UserTypeService userTypeService;

    @Test
    void findAll() {
        List<UserType> userTypeList = new ArrayList<>();
        
        var userType1 = new UserType(1L, "Professor", "Professor da plataforma");
        var userType2 = new UserType(2L, "Administrador", "Administrador da plataforma");
        
        userTypeList.addAll(Arrays.asList(userType1, userType2));
        Mockito.when(userTypeService.findAll()).thenReturn(userTypeList);

       Assertions.assertThat(userTypeService.findAll()).isNotEmpty(); 
    }

}
