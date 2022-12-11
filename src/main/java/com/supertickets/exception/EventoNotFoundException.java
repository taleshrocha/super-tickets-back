package com.supertickets.exception;

public class EventoNotFoundException extends RuntimeException {

  public EventoNotFoundException(Long id) {
    super("Could not find event " + id);
  }
}
