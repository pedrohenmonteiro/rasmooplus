package com.mont.rasmooplus.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mont.rasmooplus.dto.LoginDto;
import com.mont.rasmooplus.dto.TokenDto;
import com.mont.rasmooplus.dto.UserDetailsDto;
import com.mont.rasmooplus.model.redis.UserRecoveryCode;
import com.mont.rasmooplus.service.AuthenticationService;
import com.mont.rasmooplus.service.UserDetailsService;



@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping
    public ResponseEntity<TokenDto> auth(@RequestBody @Valid LoginDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.auth(dto));
    }
    
    @PostMapping("/recovery-code/send")
    public ResponseEntity<Void> sendRecoveryCode(@RequestBody @Valid UserRecoveryCode dto) {
        userDetailsService.sendRecoveryCode(dto.getEmail());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/recovery-code/")
    public ResponseEntity<Boolean> isRecoveryCodeValid(@RequestParam String recoveryCode, @RequestParam String email) {
        return ResponseEntity.ok().body(userDetailsService.recoveryCodeIsValid(recoveryCode, email));
    }

    @PatchMapping("/recovery-code/password")
    public ResponseEntity<Void> sendRecoveryCode(@RequestBody @Valid UserDetailsDto dto) {
        userDetailsService.updatePasswordByRecoveryCode(dto);
        return ResponseEntity.noContent().build();
    }

}