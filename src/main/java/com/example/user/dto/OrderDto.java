package com.example.user.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OrderDto {
    private Long id;
    //private Status status;
    private String senderName;
    private String senderPhone;
    private String receiverName;
    private String receiverPhone;
    private Integer parcelNumber;
    private Double cost;
    private LocalDateTime pickupDate;
    private String senderCity;
    private String senderCounty;
    private String senderCountry;
    private String senderAddress;

    private String receiverCity;
    private String receiverCounty;
    private String receiverCountry;
    private String receiverAddress;
}
