package com.supertickets.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.supertickets.model.Cliente;
import com.supertickets.controller.ClienteController;

@Component
public class ClienteModelAssembler implements RepresentationModelAssembler<Cliente, EntityModel<Cliente>> {

  @Override
  public EntityModel<Cliente> toModel(Cliente cliente) {
    return EntityModel.of(cliente,
        linkTo(methodOn(ClienteController.class).one(cliente.getId())).withSelfRel(),
        linkTo(methodOn(ClienteController.class).all()).withRel("Todos os clientes"));
  }
}
