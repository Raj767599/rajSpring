package com.raj.springexperiment.controller;

import com.raj.springexperiment.model.BookSlot;
import com.raj.springexperiment.repository.BookSlotRepository;
import com.raj.springexperiment.request.BookSlotRequest;
import com.raj.springexperiment.service.BookSlotService;
import com.raj.springexperiment.service.CsvExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
public class BookSlotController {
    @Autowired
    BookSlotService slService;
    @Autowired
    BookSlotRepository bookSlotrepo;

    @Autowired
    private final CsvExportService csvExportService;

    public BookSlotController(CsvExportService csvExportService) {
        this.csvExportService = csvExportService;
    }


    @PostMapping("/slot")
    public ResponseEntity<String> saveEmployee(@Valid @RequestBody BookSlotRequest  eSlot){

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
        return new ResponseEntity<String>("Record succefully saved", HttpStatus.CREATED);

    }






    @RequestMapping(path = "/employees")
    public void getAllEmployeesInCsv(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"employees.csv\"");
        csvExportService.bookslotCSV(servletResponse.getWriter());
    }

    @RequestMapping(path = "/book")
    public void saveBookslot(@Valid @RequestBody BookSlotRequest  eSlot) throws IOException {
        slService.saveBookslot(eSlot);
    }

//    @PostMapping("/employees")
//    public void saveBookslot(@Valid @RequestBody BookSlotRequest  eSlot){
//       slService.saveBookslot(eSlot);
//    }


}
