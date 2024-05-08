package com.warehouse.management.customer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CustomerDto {

    @JsonProperty("customer_id")
    private int customerId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String mail;

    private String phone;

    private int point;

    @JsonProperty("num_of_address")
    private int numOfAddress;
}
