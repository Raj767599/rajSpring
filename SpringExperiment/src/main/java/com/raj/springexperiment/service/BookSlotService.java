package com.raj.springexperiment.service;

import com.raj.springexperiment.model.BookSlot;
import com.raj.springexperiment.repository.BookSlotRepository;
import com.raj.springexperiment.request.BookSlotRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookSlotService {


    @Autowired
    BookSlotRepository bookSlotrepo;

    public void saveBookslot(BookSlotRequest eSlot) {
        for (String s : eSlot.getSelectedDate()){
            BookSlot d=new BookSlot();
            d.setSlotDate(s);
            d.setEmployeeName(eSlot.getEmployeeName());
            d.setCabFacility(eSlot.getCabFacility());
            d.setEmployeeDepartment(eSlot.getEmployeeDepartment());
            d.setShiftTiming(eSlot.getShiftTiming());
            d.setMealFacility(eSlot.getMealFacility());
            d.setSlotRecurrence(eSlot.getSlotRecurrence());
            d.setVaccination(eSlot.getVaccination());


            bookSlotrepo.save(d);

        }

    }
}
