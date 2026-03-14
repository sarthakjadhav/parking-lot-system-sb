package com.com.parkinglotsb.parking_lot_system_sb.service;

import com.com.parkinglotsb.parking_lot_system_sb.models.Bill;
import com.com.parkinglotsb.parking_lot_system_sb.models.Ticket;
import com.com.parkinglotsb.parking_lot_system_sb.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class BillService {

    private final BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill generateBill(Ticket ticket) {

        LocalDateTime exitTime = LocalDateTime.now();

        long hours = Duration.between(ticket.getEntryTime(), exitTime).toHours();

        if (hours == 0) {
            hours = 1;
        }

        double amount = hours * 20;

        Bill bill = new Bill();
        bill.setTicketId(ticket.getId());
        bill.setExitTime(exitTime);
        bill.setAmount(amount);

        return billRepository.save(bill);
    }
}