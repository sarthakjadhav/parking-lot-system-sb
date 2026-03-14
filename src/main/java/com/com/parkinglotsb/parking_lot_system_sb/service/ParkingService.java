package com.com.parkinglotsb.parking_lot_system_sb.service;

import com.com.parkinglotsb.parking_lot_system_sb.enums.SpotStatus;
import com.com.parkinglotsb.parking_lot_system_sb.enums.VehicleType;
import com.com.parkinglotsb.parking_lot_system_sb.models.ParkingSpot;
import com.com.parkinglotsb.parking_lot_system_sb.repository.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {
    private final ParkingSpotRepository parkingSpotRepository;

    public ParkingService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public ParkingSpot findAvailableSpot(VehicleType vehicleType){
        List<ParkingSpot> spots = parkingSpotRepository.findAll();

        for(ParkingSpot spot: spots){
            if(spot.getVehicleType() == vehicleType &&
                spot.getStatus() == SpotStatus.AVAILABLE){
                return spot;
            }
        }

        throw new RuntimeException("Spot not available...");
    }

    public void occupySpot(ParkingSpot spot) {

        spot.setStatus(SpotStatus.OCCUPIED);
        parkingSpotRepository.save(spot);
    }

    public void freeSpot(ParkingSpot spot) {

        spot.setStatus(SpotStatus.AVAILABLE);
        parkingSpotRepository.save(spot);
    }
}
