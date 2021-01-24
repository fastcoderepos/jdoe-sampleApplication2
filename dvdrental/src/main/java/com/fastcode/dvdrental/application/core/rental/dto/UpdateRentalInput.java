package com.fastcode.dvdrental.application.core.rental.dto;

import java.time.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRentalInput {

    private LocalDate rentalDate;

    @NotNull(message = "rentalId Should not be null")
    private Integer rentalId;

    private LocalDate returnDate;

    private Integer customerId;
    private Integer inventoryId;
    private Integer staffId;
    private Long versiono;
}
