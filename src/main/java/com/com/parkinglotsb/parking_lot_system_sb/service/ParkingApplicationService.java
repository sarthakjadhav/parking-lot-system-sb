package com.com.parkinglotsb.parking_lot_system_sb.service;

import com.com.parkinglotsb.parking_lot_system_sb.enums.VehicleType;
import com.com.parkinglotsb.parking_lot_system_sb.models.Bill;
import com.com.parkinglotsb.parking_lot_system_sb.models.ParkingSpot;
import com.com.parkinglotsb.parking_lot_system_sb.models.Ticket;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParkingApplicationService {

    private final ParkingService parkingService;
    private final TicketService ticketService;
    private final BillService billService;

    public ParkingApplicationService(ParkingService parkingService,
                                     TicketService ticketService,
                                     BillService billService) {
        this.parkingService = parkingService;
        this.ticketService = ticketService;
        this.billService = billService;
    }

    @Transactional
    public Ticket handleVehicleEntry(String vehicleNumber, VehicleType vehicleType) {

        ParkingSpot spot = parkingService.findAvailableSpot(vehicleType);

        parkingService.occupySpot(spot);

        return ticketService.generateTicket(vehicleNumber, spot);
    }

    @Transactional
    public Bill handleVehicleExit(Long ticketId) {

        Ticket ticket = ticketService.getTicket(ticketId);

        Bill bill = billService.generateBill(ticket);

        ParkingSpot spot = new ParkingSpot();
        spot.setId(ticket.getParkingSpotId());

        parkingService.freeSpot(spot);

        return bill;
    }
}