package com.mont.rasmooplus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mont.rasmooplus.model.UserType;
import com.mont.rasmooplus.service.UserTypeService;

@RestController
@RequestMapping("/user-type")
public class UserTypeController {
    
    @Autowired
    private UserTypeService service;

    @GetMapping
    ResponseEntity<List<UserType>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}
