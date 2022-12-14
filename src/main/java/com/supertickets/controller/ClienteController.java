package com.supertickets.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supertickets.assembler.ClienteModelAssembler;
import com.supertickets.dao.ClienteRepository;
import com.supertickets.exception.ClienteNotFoundException;
import com.supertickets.model.Cliente;

@RestController
public class ClienteController {

  private final ClienteRepository clienteRepository;
  private final ClienteModelAssembler clienteAssembler;

  ClienteController(ClienteRepository clienteRepository, ClienteModelAssembler clienteAssembler) {
    this.clienteRepository = clienteRepository;
    this.clienteAssembler = clienteAssembler;
  }

  @GetMapping("/clientes")
  public CollectionModel<EntityModel<Cliente>> all() {

    List<EntityModel<Cliente>> clientes = clienteRepository.findAll().stream()
        .map(clienteAssembler::toModel)
        .collect(Collectors.toList());

    return CollectionModel.of(clientes,
        linkTo(methodOn(ClienteController.class).all()).withSelfRel());

  }

  @GetMapping("/clientes/{id}")
  public EntityModel<Cliente> one(@PathVariable Long id) {

    Cliente cliente = clienteRepository.findById(id)
        .orElseThrow(() -> new ClienteNotFoundException(id));

    return clienteAssembler.toModel(cliente);
  }

  @PostMapping("/clientes")
  public ResponseEntity<?> newCliente(@RequestBody Cliente newCliente) {
    EntityModel<Cliente> entityModel = clienteAssembler.toModel(clienteRepository.save(newCliente));

    return ResponseEntity
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entityModel);
  }

  @DeleteMapping("/clientes/{id}")
  public ResponseEntity<?> removeCliente(@PathVariable Long id) {

    clienteRepository.deleteById(id);

    return ResponseEntity.noContent().build();
  }
}
