package com.supertickets.exception;

public class ClienteNotFoundException extends RuntimeException {

  public ClienteNotFoundException(Long id) {
    super("Could not find cliente " + id);
  }
}
