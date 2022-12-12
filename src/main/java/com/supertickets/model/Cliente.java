package com.supertickets.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {

  private @Id @GeneratedValue Long id;
  private String nome;
  private String numeroTelefone;
  private String contaBancaria;

  public Cliente() {
  }

  public Cliente(String nome, String numeroTelefone, String contaBancaria) {
    this.nome = nome;
    this.numeroTelefone = numeroTelefone;
    this.contaBancaria = contaBancaria;
  }

  public Long getId() {
    return id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNumeroTelefone(String numeroTelefone) {
    this.numeroTelefone = numeroTelefone;
  }

  public String getNumeroTelefone() {
    return numeroTelefone;
  }

  public void setContaBancaria(String contaBancaria) {
    this.contaBancaria = contaBancaria;
  }

  public String getContaBancaria() {
    return contaBancaria;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;

    if (!(o instanceof Cliente))
      return false;

    Cliente cliente = (Cliente) o;

    return Objects.equals(this.id, cliente.id)
        && Objects.equals(this.nome, cliente.nome)
        && Objects.equals(this.contaBancaria, cliente.contaBancaria)
        && Objects.equals(this.numeroTelefone, cliente.numeroTelefone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.nome, this.numeroTelefone, this.contaBancaria);
  }

  @Override
  public String toString() {
    return "Cliente{"
        + "id=" + this.id
        + ", numeroTelefone='" + this.numeroTelefone + '\''
        + ", contaBancaria='" + this.contaBancaria + '\''
        + '}';
  }
}
