package com.supertickets.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.supertickets.assembler.TicketModelAssembler;
import com.supertickets.dao.TicketRepository;
import com.supertickets.exception.TicketNotFoundException;
import com.supertickets.model.Ticket;

@RestController
public class TicketController {

  private final TicketRepository ticketRepository;
  private final TicketModelAssembler ticketAssembler;

  TicketController(TicketRepository ticketRepository, TicketModelAssembler ticketAssembler) {
    this.ticketRepository = ticketRepository;
    this.ticketAssembler = ticketAssembler;
  }

  @GetMapping("/tickets")
  public CollectionModel<EntityModel<Ticket>> all() {

    List<EntityModel<Ticket>> tickets = ticketRepository.findAll().stream()
        .map(ticketAssembler::toModel)
        .collect(Collectors.toList());

    return CollectionModel.of(tickets,
        linkTo(methodOn(TicketController.class).all()).withSelfRel());
  }

  @GetMapping("/tickets/{id}")
  public EntityModel<Ticket> one(@PathVariable Long id) {

    Ticket ticket = ticketRepository.findById(id)
        .orElseThrow(() -> new TicketNotFoundException(id));

    return ticketAssembler.toModel(ticket);
  }
}
