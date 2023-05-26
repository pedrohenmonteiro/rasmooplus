package com.mont.rasmooplus.service.impl;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mont.rasmooplus.exception.BadRequestException;
import com.mont.rasmooplus.exception.NotFoundException;
import com.mont.rasmooplus.integration.MailIntegration;
import com.mont.rasmooplus.model.jpa.UserCredentials;
import com.mont.rasmooplus.model.redis.UserRecoveryCode;
import com.mont.rasmooplus.repository.jpa.UserDetailsRepository;
import com.mont.rasmooplus.repository.redis.UserRecoveryCodeRepository;
import com.mont.rasmooplus.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired UserRecoveryCodeRepository userRecoveryCodeRepository;

    @Autowired
    private MailIntegration mailIntegration;

    @Override
    public UserCredentials loadUserByUsernameAndPass(String username, String pass) {

        var userCredentialsOpt = userDetailsRepository.findByUsername(username);

        if (userCredentialsOpt.isEmpty()) {
            throw new NotFoundException("Usuário não encontrado");
        }

        UserCredentials userCredentials = userCredentialsOpt.get();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (encoder.matches(pass, userCredentials.getPassword())) {
            return userCredentials;
        }

        throw new BadRequestException("Usuário ou senha inválido");
    }

    @Override
    public void sendRecoveryCode(String email) {
        UserRecoveryCode userRecoveryCode;
        String code = String.format("%4d", new Random().nextInt(10000));

        var userRecoveryCodeOpt = userRecoveryCodeRepository.findByEmail(email);

        if(userRecoveryCodeOpt.isEmpty()) {
        var user = userDetailsRepository.findByUsername(email).orElseThrow(() -> new NotFoundException("User not found"));
    
        userRecoveryCode = new UserRecoveryCode();
        userRecoveryCode.setEmail(email);  
        } else {
            userRecoveryCode = userRecoveryCodeOpt.get();
        }
        userRecoveryCode.setCode(code);
        userRecoveryCode.setCreationDate(LocalDateTime.now());


        userRecoveryCodeRepository.save(userRecoveryCode);
        mailIntegration.send(email, "Código de recuperaçao de conta: "+code, "Código de recuperação de conta");
    }

    @Override
    public boolean recoveryCodeIsValid(String recoveryCode, String email) {
        var userRecoveryCodeOpt = userRecoveryCodeRepository.findByEmail(email);
        if(userRecoveryCodeOpt.isEmpty()) {
            throw new NotFoundException("User not found");
        }

        UserRecoveryCode userRecoveryCode = userRecoveryCodeOpt.get();
        if(recoveryCode.equals(userRecoveryCode.getCode())) {
            return true;
        }
        return false;
    }

    
}
