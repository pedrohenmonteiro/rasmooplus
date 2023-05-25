package com.mont.rasmooplus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mont.rasmooplus.dto.LoginDto;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    
    @PostMapping
    public ResponseEntity<?> auth(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok().body(null);
    }
}
