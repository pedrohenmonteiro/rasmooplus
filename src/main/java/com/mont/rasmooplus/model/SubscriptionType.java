package com.mont.rasmooplus.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 * CREATE TABLE if not exists `subscriptions_type`(
                                                   `subscriptions_type_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                                   `name` CHAR(255) NOT NULL,
                                                   `access_months` INT ,
                                                   `price` DECIMAL(10,2) NOT NULL,
                                                   `product_key` CHAR(255)
);

 */
@Entity
@Table(name = "subscriptions_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionType implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriptions_type_id")
    private Long id;
    private String name;
    @Column(name = "access_months")
    private Long accessMonths;
    private BigDecimal price;
    @Column(name = "product_key", unique = true)
    private String productKey;
}
