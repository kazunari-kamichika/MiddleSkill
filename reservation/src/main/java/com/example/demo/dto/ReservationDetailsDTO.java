package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class ReservationDetailsDTO {

	private String userName;
    private String userPhone;
    private String userEmail;
    private String planName;
    private BigDecimal planPrice;
    private LocalDateTime reservationDate;
    
    // フォーマットされた予約日時を返すメソッド
    public String getFormattedReservationDate() {
        if (reservationDate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return reservationDate.format(formatter);  // yyyy-MM-dd形式で日付をフォーマット
        }
        return "";  // 日付がnullの場合は空文字を返す
    }
}