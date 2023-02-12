package com.raj.springexperiment.service;

import com.raj.springexperiment.model.BookSlot;
import com.raj.springexperiment.repository.BookSlotRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.logging.Logger;
@Service
public class CsvExportService {


    private final BookSlotRepository bookSlotRepository;

    public CsvExportService(BookSlotRepository employeeRepository) {
        this.bookSlotRepository = employeeRepository;
    }

    public void bookslotCSV(Writer writer) {

        List<BookSlot> bookslot = bookSlotRepository.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (BookSlot books : bookslot) {
                csvPrinter.printRecord(books.getSlotId(),books.getEmployeeName(),books.getSlotDate(),books.getCabFacility(),books.getSlotRecurrence(),books.getEmployeeDepartment(),books.getMealFacility(),books.getShiftTiming(),books.getVaccination());
            }
        } catch (IOException e) {

        }
    }
}
