package com.com.parkinglotsb.parking_lot_system_sb.service;

import com.com.parkinglotsb.parking_lot_system_sb.models.ParkingSpot;
import com.com.parkinglotsb.parking_lot_system_sb.models.Ticket;
import com.com.parkinglotsb.parking_lot_system_sb.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(String vehicleNumber, ParkingSpot spot) {

        Ticket ticket = new Ticket();

        ticket.setVehicleNumber(vehicleNumber);
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setParkingSpotId(spot.getId());

        return ticketRepository.save(ticket);
    }

    public Ticket getTicket(Long ticketId) {

        return ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }
}