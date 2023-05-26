package com.mont.rasmooplus.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mont.rasmooplus.dto.LoginDto;
import com.mont.rasmooplus.dto.TokenDto;
import com.mont.rasmooplus.service.AuthenticationService;



@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<TokenDto> auth(@RequestBody @Valid LoginDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.auth(dto));
    }

}