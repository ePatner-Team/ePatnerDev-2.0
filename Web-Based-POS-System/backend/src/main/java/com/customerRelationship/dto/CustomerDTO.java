package com.customerRelationship.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private int loyaltyPoints;
}