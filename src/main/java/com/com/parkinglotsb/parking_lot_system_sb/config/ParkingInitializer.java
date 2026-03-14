package com.com.parkinglotsb.parking_lot_system_sb.config;

import com.com.parkinglotsb.parking_lot_system_sb.enums.SpotStatus;
import com.com.parkinglotsb.parking_lot_system_sb.enums.VehicleType;
import com.com.parkinglotsb.parking_lot_system_sb.models.ParkingSpot;
import com.com.parkinglotsb.parking_lot_system_sb.repository.ParkingSpotRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ParkingInitializer {

    private final ParkingSpotRepository parkingSpotRepository;

    public ParkingInitializer(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @PostConstruct
    public void initializeParkingSpots() {

        // avoid re-initializing if spots already exist
        if (parkingSpotRepository.count() > 0) {
            return;
        }

        int floors = 4;
        int twoWheelerSpotsPerFloor = 5;
        int fourWheelerSpotsPerFloor = 5;

        for (int floor = 1; floor <= floors; floor++) {

            for (int i = 0; i < twoWheelerSpotsPerFloor; i++) {

                ParkingSpot spot = new ParkingSpot();
                spot.setFloorNumber(floor);
                spot.setVehicleType(VehicleType.TWOWHEELER);
                spot.setStatus(SpotStatus.AVAILABLE);

                parkingSpotRepository.save(spot);
            }

            for (int i = 0; i < fourWheelerSpotsPerFloor; i++) {

                ParkingSpot spot = new ParkingSpot();
                spot.setFloorNumber(floor);
                spot.setVehicleType(VehicleType.FOURWHEELER);
                spot.setStatus(SpotStatus.AVAILABLE);

                parkingSpotRepository.save(spot);
            }
        }

        System.out.println("Parking spots initialized successfully.");
    }
}