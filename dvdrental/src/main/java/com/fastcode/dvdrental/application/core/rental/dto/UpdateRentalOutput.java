package com.fastcode.dvdrental.application.core.rental.dto;

import java.time.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRentalOutput {

    private LocalDate rentalDate;
    private Integer rentalId;
    private LocalDate returnDate;
    private Integer customerId;
    private Integer customerDescriptiveField;
    private Integer inventoryId;
    private Integer inventoryDescriptiveField;
    private Integer staffId;
    private Integer staffDescriptiveField;
}
