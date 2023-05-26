package com.mont.rasmooplus.model.redis;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("recoveryCode")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecoveryCode {
  
    @Id
    private String id;
    
    private String email;

    private String code;

    private LocalDateTime creationDate = LocalDateTime.now();
}
