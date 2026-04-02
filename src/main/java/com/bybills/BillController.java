package com.bybills;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/bills")
public class BillController {

    @Autowired
    private BillService billService;

    // Get all bills
    @GetMapping
    public List<Bill> getBills() {
        return billService.getAllBills();
    }

    // Add bill
    @PostMapping
    public Bill addBill(@RequestBody Bill bill) {
        return billService.addBill(bill);
    }

    // Delete bill
    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
    }

    // Get overdue bills
    @GetMapping("/overdue")
    public List<Bill> getOverdueBills() {
        return billService.getAllBills();
    }

    // Get today's bills
    @GetMapping("/today")
    public List<Bill> getTodayBills() {
        return billService.getAllBills();
    }

    // Get upcoming bills
    @GetMapping("/upcoming")
    public List<Bill> getUpcomingBills() {
        return billService.getAllBills();
    }
}