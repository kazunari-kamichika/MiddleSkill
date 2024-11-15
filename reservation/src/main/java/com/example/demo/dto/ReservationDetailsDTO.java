package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReservationDetailsDTO {

	private String userName;
    private String userPhone;
    private String userEmail;
    private String planName;
    private BigDecimal planPrice;
    private LocalDateTime reservationDate;
}
