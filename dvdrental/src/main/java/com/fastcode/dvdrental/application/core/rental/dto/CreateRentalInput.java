package com.fastcode.dvdrental.application.core.rental.dto;

import java.time.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRentalInput {

    private LocalDate rentalDate;

    private LocalDate returnDate;

    private Integer customerId;
    private Integer inventoryId;
    private Integer staffId;
}
