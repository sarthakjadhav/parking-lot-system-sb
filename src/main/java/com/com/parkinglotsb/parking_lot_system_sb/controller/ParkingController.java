package com.com.parkinglotsb.parking_lot_system_sb.controller;

import com.com.parkinglotsb.parking_lot_system_sb.enums.VehicleType;
import com.com.parkinglotsb.parking_lot_system_sb.models.Bill;
import com.com.parkinglotsb.parking_lot_system_sb.models.Ticket;
import com.com.parkinglotsb.parking_lot_system_sb.service.ParkingApplicationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingApplicationService parkingApplicationService;

    public ParkingController(ParkingApplicationService parkingApplicationService) {
        this.parkingApplicationService = parkingApplicationService;
    }

    @PostMapping("/entry")
    public Ticket vehicleEntry(@RequestParam String vehicleNumber,
                               @RequestParam VehicleType vehicleType) {

        return parkingApplicationService
                .handleVehicleEntry(vehicleNumber, vehicleType);
    }

    @PostMapping("/exit")
    public Bill vehicleExit(@RequestParam Long ticketId) {

        return parkingApplicationService
                .handleVehicleExit(ticketId);
    }
}