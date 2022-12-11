package com.supertickets.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Evento {

    private @Id @GeneratedValue Long id;

    private String nome;
    private String endereco;
    // private @OneToMany ArrayList<Ticket> tickets;

    Evento() {
    }

    public Evento(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Evento))
            return false;

        Evento evento = (Evento) o;

        return Objects.equals(this.id, evento.id)
                && Objects.equals(this.nome, evento.nome)
                && Objects.equals(this.endereco, evento.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nome, this.endereco);
    }

    @Override
    public String toString() {
        return "Evento{"
                + "id=" + this.id
                + ", nome='" + this.nome + '\''
                + ", endereco='" + this.endereco + '\''
                + '}';
    }
}
