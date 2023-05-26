package com.mont.rasmooplus.service;

import java.util.List;

import com.mont.rasmooplus.model.jpa.UserType;

public interface UserTypeService {
    List<UserType> findAll();
}
