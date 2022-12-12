package com.supertickets.exception;

public class ClienteTicketNotFoundException extends RuntimeException {

  public ClienteTicketNotFoundException(Long id) {
    super("Could not find clienteTicket " + id);
  }
}
