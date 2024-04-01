package com.kevin.bioskop.Model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrxPaymentResponse {
    private String id;
    private String loanId;
    private String customerId;
    private Long amount;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Jakarta")
    private Date date;
    private PaymentResponse paymentResponse;
}

