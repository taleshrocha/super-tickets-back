package com.supertickets.model;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
public class Cliente {
    private String name;
    private String numeroTelefone;
    private String contaBancaria;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String documento;
    @OneToMany
    private ArrayList<Ticket> ticktesPessoal;

    public Cliente(){
        //
    }

    public void setName(String name){
        this.name = name;
    }
    public String get() {
        return this.name;
    }

    public void setTelefone(String telefone){
        this.numeroTelefone = telefone;
    }
    public String getTelefone() {
        return this.numeroTelefone;
    }

    public void setConta(String conta){
        this.contaBancaria = conta; 
    }
    public String getConta() {
        return this.contaBancaria;
    }
    
    public void setDocumento(String documento){
        this.documento = documento; 
    }
    public String getDocumento() {
        return this.documento;
    }

    public void set(int id){
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
}
