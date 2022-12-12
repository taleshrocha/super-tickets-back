package com.supertickets.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.supertickets.assembler.ClienteModelAssembler;
import com.supertickets.assembler.TicketModelAssembler;
import com.supertickets.dao.ClienteRepository;
import com.supertickets.dao.ClienteTicketRepository;
import com.supertickets.dao.TicketRepository;
import com.supertickets.exception.ClienteNotFoundException;
import com.supertickets.exception.ClienteTicketNotFoundException;
import com.supertickets.model.Cliente;
import com.supertickets.model.ClienteTicket;
import com.supertickets.model.Ticket;

@RestController
public class ClienteController {

  private final ClienteRepository clienteRepository;
  private final ClienteTicketRepository clienteTicketRepository;
  private final ClienteModelAssembler clienteAssembler;
  private final TicketModelAssembler ticketModelAssembler;

  ClienteController(ClienteRepository clienteRepository, ClienteModelAssembler clienteAssembler,
      ClienteTicketRepository clienteTicketRepository, TicketModelAssembler ticketModelAssembler) {
    this.clienteRepository = clienteRepository;
    this.clienteAssembler = clienteAssembler;
    this.clienteTicketRepository = clienteTicketRepository;
    this.ticketModelAssembler = ticketModelAssembler;
  }

  @GetMapping("/clientes")
  public CollectionModel<EntityModel<Cliente>> all() {

    List<EntityModel<Cliente>> clientes = clienteRepository.findAll().stream()
        .map(clienteAssembler::toModel)
        .collect(Collectors.toList());

    return CollectionModel.of(clientes,
        linkTo(methodOn(ClienteController.class).all()).withSelfRel());

  }

  @GetMapping("clientes/{id}")
  public EntityModel<Cliente> one(@PathVariable Long id) {

    Cliente cliente = clienteRepository.findById(id)
        .orElseThrow(() -> new ClienteNotFoundException(id));

    return clienteAssembler.toModel(cliente);
  }

}
