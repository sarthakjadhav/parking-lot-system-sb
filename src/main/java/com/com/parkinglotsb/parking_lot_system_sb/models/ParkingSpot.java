package com.com.parkinglotsb.parking_lot_system_sb.models;

import com.com.parkinglotsb.parking_lot_system_sb.enums.SpotStatus;
import com.com.parkinglotsb.parking_lot_system_sb.enums.VehicleType;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int floorNumber;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Enumerated(EnumType.STRING)
    private SpotStatus status;


}
