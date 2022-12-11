package com.supertickets.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.supertickets.model.Ticket;
import com.supertickets.controller.TicketController;

@Component
public class TicketModelAssembler implements RepresentationModelAssembler<Ticket, EntityModel<Ticket>> {

  @Override
  public EntityModel<Ticket> toModel(Ticket ticket) {
    return EntityModel.of(ticket,
        linkTo(methodOn(TicketController.class).one(ticket.getId())).withSelfRel(),
        linkTo(methodOn(TicketController.class).all()).withRel("Todos os tickets"));
  }
}
