package com.bybills;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {

    // Bills whose due date is before today
    List<Bill> findByDueDateBefore(LocalDate date);

    // Bills due today
    List<Bill> findByDueDate(LocalDate date);

    // Bills whose due date is after today
    List<Bill> findByDueDateAfter(LocalDate date);

}