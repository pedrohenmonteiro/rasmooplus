package com.mont.rasmooplus.service;

import com.mont.rasmooplus.model.UserCredentials;

public interface UserDetailsService {
    
   UserCredentials loadUserByUsernameAndPass(String username, String pass);
}
