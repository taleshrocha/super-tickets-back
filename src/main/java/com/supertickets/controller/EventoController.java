package com.supertickets.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Id;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.supertickets.assembler.EventoModelAssembler;
import com.supertickets.dao.EventoRepository;
import com.supertickets.exception.EventoNotFoundException;
import com.supertickets.model.Evento;

@RestController
public class EventoController {

  private final EventoRepository eventoRepository;
  private final EventoModelAssembler eventoAssembler;

  EventoController(EventoRepository eventoRepository, EventoModelAssembler eventoAssembler) {
    this.eventoRepository = eventoRepository;
    this.eventoAssembler = eventoAssembler;
  }

  @GetMapping("/eventos")
  public CollectionModel<EntityModel<Evento>> all() {

    List<EntityModel<Evento>> eventos = eventoRepository.findAll().stream()
        .map(eventoAssembler::toModel)
        .collect(Collectors.toList());

    return CollectionModel.of(eventos,
        linkTo(methodOn(EventoController.class).all()).withSelfRel());

  }

  @GetMapping("eventos/{id}")
  public EntityModel<Evento> one(@PathVariable Long id) {

    Evento evento = eventoRepository.findById(id)
        .orElseThrow(() -> new EventoNotFoundException(id));

    return eventoAssembler.toModel(evento);
  }
}
