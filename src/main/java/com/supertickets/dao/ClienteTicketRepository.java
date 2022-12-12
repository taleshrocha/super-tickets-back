package com.supertickets.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supertickets.model.ClienteTicket;

public interface ClienteTicketRepository extends JpaRepository<ClienteTicket, Long> {

  List<ClienteTicket> findByIdCliente(Long idCliente);

}
