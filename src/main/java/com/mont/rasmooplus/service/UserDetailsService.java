package com.mont.rasmooplus.service;

import com.mont.rasmooplus.dto.UserDetailsDto;
import com.mont.rasmooplus.model.jpa.UserCredentials;

public interface UserDetailsService {
    
   UserCredentials loadUserByUsernameAndPass(String username, String pass);

   void sendRecoveryCode(String email);

   boolean recoveryCodeIsValid(String recoveryCode, String email);

   void updatePasswordByRecoveryCode(UserDetailsDto dto);
}
