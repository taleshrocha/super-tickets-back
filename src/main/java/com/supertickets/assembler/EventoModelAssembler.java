package com.supertickets.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.supertickets.model.Evento;
import com.supertickets.controller.EventoController;

@Component
public class EventoModelAssembler implements RepresentationModelAssembler<Evento, EntityModel<Evento>> {

  @Override
  public EntityModel<Evento> toModel(Evento evento) {
    return EntityModel.of(evento,
        linkTo(methodOn(EventoController.class).all()).withRel("eventos"));
  }

}
