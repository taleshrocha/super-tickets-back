package com.supertickets.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supertickets.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

  List<Ticket> findByIdEvento(Long idEvento);
}
