package com.mont.rasmooplus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mont.rasmooplus.model.SubscriptionType;
import com.mont.rasmooplus.service.SubscriptionTypeService;

@RestController
@RequestMapping("/subscription-type")
public class SubscriptionTypeController {
    
    @Autowired
    private SubscriptionTypeService service;

    @GetMapping
    public ResponseEntity<List<SubscriptionType>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}
