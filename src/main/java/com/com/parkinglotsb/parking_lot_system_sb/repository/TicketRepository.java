package com.com.parkinglotsb.parking_lot_system_sb.repository;


import com.com.parkinglotsb.parking_lot_system_sb.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
