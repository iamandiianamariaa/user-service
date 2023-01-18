package com.example.user.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date pickupDate;
    private String senderCity;
    private String senderCounty;
    private String senderCountry;
    private String senderAddress;

    private String receiverCity;
    private String receiverCounty;
    private String receiverCountry;
    private String receiverAddress;
}
