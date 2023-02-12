package com.raj.springexperiment.repository;

import com.raj.springexperiment.model.BookSlot;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookSlotRepository extends JpaRepository<BookSlot, Long> {
}
