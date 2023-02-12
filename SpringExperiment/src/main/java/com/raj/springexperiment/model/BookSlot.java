package com.raj.springexperiment.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Setter
@Getter
@ToString
@Entity
@Table(name = "Book_Slot")
public class BookSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slotId;
    private String slotDate;
    private String employeeName;
    private String cabFacility;
    private String employeeDepartment;
    private String mealFacility;
    private String shiftTiming;
    private String slotRecurrence;
    private String vaccination;

}
