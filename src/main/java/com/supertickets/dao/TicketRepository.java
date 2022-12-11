package com.supertickets.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supertickets.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
