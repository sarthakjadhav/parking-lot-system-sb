package com.com.parkinglotsb.parking_lot_system_sb.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleNumber;

    private LocalDateTime entryTime;

    private Long parkingSpotId;
}
