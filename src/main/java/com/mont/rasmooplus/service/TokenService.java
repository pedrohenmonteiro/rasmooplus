package com.mont.rasmooplus.service;

public interface TokenService {
    String getToken(Long userId);

    Boolean isValid(String token);

    Long getUserId(String token);
}
