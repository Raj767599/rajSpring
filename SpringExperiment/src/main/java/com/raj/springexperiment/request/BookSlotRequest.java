package com.raj.springexperiment.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
@Getter
@Setter
public class BookSlotRequest {

    private Long slotId;
    private String slotDate;
    private String employeeName;
    private String cabFacility;
    private String employeeDepartment;
    private String mealFacility;
    private String shiftTiming;
    private String slotRecurrence;
    private String vaccination;


    private List<String> selectedDate;
}
