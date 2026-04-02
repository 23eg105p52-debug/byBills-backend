package com.bybills;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    // Get all bills
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    // Add new bill
    public Bill addBill(Bill bill) {
        return billRepository.save(bill);
    }

    // Delete bill
    public void deleteBill(Long id) {
        billRepository.deleteById(id);
    }

    // Get overdue bills
    public List<Bill> getOverdueBills() {
        return billRepository.findByDueDateBefore(LocalDate.now());
    }

    // Get today's bills
    public List<Bill> getTodayBills() {
        return billRepository.findByDueDate(LocalDate.now());
    }

    // Get upcoming bills
    public List<Bill> getUpcomingBills() {
        return billRepository.findByDueDateAfter(LocalDate.now());
    }
}