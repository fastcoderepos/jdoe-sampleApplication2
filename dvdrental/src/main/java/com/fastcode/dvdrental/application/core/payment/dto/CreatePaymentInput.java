package com.fastcode.dvdrental.application.core.payment.dto;

import java.math.BigDecimal;
import java.time.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentInput {

    @NotNull(message = "amount Should not be null")
    private BigDecimal amount;

    private LocalDate paymentDate;

    private Integer customerId;
    private Integer rentalId;
    private Integer staffId;
}
