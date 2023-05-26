package com.mont.rasmooplus.model.redis;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("recoveryCode")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRecoveryCode {
  
    @Id
    private String id;
    
    @Indexed
    @Email
    private String email;

    private String code;

    private LocalDateTime creationDate = LocalDateTime.now();
}
