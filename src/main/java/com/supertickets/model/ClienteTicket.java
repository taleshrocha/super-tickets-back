package com.supertickets.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ClienteTicket {

  private @Id @GeneratedValue Long id;
  private Long idCliente;
  private Long idTicket;

  public ClienteTicket() {
  }

  public ClienteTicket(Long idCliente, Long idTicket) {
    this.idCliente = idCliente;
    this.idTicket = idTicket;
  }

  public Long getId() {
    return id;
  }

  public void setIdCliente(Long idCliente) {
    this.idCliente = idCliente;
  }

  public Long getIdCliente() {
    return idCliente;
  }

  public void setIdTicket(Long idTicket) {
    this.idTicket = idTicket;
  }

  public Long getIdTicket() {
    return idTicket;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;

    if (!(o instanceof ClienteTicket))
      return false;

    ClienteTicket clienteTicket = (ClienteTicket) o;

    return Objects.equals(this.id, clienteTicket.id)
        && Objects.equals(this.idCliente, clienteTicket.idCliente)
        && Objects.equals(this.idTicket, clienteTicket.idTicket);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.idCliente, this.idTicket);
  }

  @Override
  public String toString() {
    return "ClienteTicket{"
        + "id=" + this.id
        + ", idCliente='" + this.idCliente + '\''
        + ", idTicket='" + this.idTicket + '\''
        + '}';
  }
}
