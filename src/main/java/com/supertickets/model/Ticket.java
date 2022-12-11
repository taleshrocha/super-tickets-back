package com.supertickets.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ticket {

  private @Id @GeneratedValue Long id;
  private double valor;
  private Long idEvento;

  public Ticket() {
  }

  public Ticket(double valor, Long idEvento) {
    this.valor = valor;
    this.idEvento = idEvento;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setIdEvento(Long idEvento) {
    this.idEvento = idEvento;
  }

  public Long getIdEvento() {
    return idEvento;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public double getValor() {
    return valor;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;

    if (!(o instanceof Ticket))
      return false;

    Ticket ticket = (Ticket) o;

    return Objects.equals(this.id, ticket.id)
        && Objects.equals(this.valor, ticket.valor)
        && Objects.equals(this.idEvento, ticket.idEvento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.valor, this.idEvento);
  }

  @Override
  public String toString() {
    return "Ticket{"
        + "id=" + this.id
        + ", valor='" + this.valor + '\''
        + ", idEvento='" + this.idEvento + '\''
        + '}';
  }
}
