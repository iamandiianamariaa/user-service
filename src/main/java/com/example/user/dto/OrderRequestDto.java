package com.example.user.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
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

    private String username;
}
