package com.kevin.bioskop.Model.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
    private String id;
    private String token;
    private String redirectUrl;
    private String transactionStatus;

}
