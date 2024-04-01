package com.kevin.bioskop.Model.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTransactionRequest {

    private String transactionId;


}
