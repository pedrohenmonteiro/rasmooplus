package com.mont.rasmooplus.service;

import com.mont.rasmooplus.model.jpa.UserCredentials;

public interface UserDetailsService {
    
   UserCredentials loadUserByUsernameAndPass(String username, String pass);

   Object sendRecoveryCode(String email);
}
