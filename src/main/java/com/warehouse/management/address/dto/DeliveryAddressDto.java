package com.warehouse.management.address.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DeliveryAddressDto {	

    @JsonProperty("address_id")
    private int addressId;

    @JsonProperty("region_id")
    private int regionId;

    @JsonProperty("customer_id")
    private int customerId;
    

    @JsonProperty("address_name")
    private String addressName;

    @JsonProperty("address")
    private String address;

    @JsonProperty("post_code")
    private String postCode;

    @JsonProperty("main")
    private int main;

    @JsonProperty("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Timestamp createdAt;

    @JsonProperty("updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Timestamp updatedAt;

}
