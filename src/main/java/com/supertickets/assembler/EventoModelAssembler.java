package com.supertickets.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.supertickets.model.Evento;
import com.supertickets.controller.EventoController;
import com.supertickets.controller.TicketController;

@Component
public class EventoModelAssembler implements RepresentationModelAssembler<Evento, EntityModel<Evento>> {

  @Override
  public EntityModel<Evento> toModel(Evento evento) {
    return EntityModel.of(evento,
        linkTo(methodOn(EventoController.class).one(evento.getId())).withSelfRel(),
        linkTo(methodOn(EventoController.class).all()).withRel("Todos os eventos"),
        linkTo(methodOn(TicketController.class).allWithEvent(evento.getId()))
            .withRel("Todos os tickets com esse evento"));
  }
}
