package com.supertickets.model;

public class Empresa {
    private int id;
    private String nome;
    private String numeroEmpresa;
    private Endereco endereco;

    public void setID(int id){
        this.id = id;
    }
    public int getID(){
        return this.id;
    }

    public void setName(String name){
        this.nome = name;
    }
    public String getName(){
        return this.nome;
    }

    public void setNumero(String telefone){
        this.numeroEmpresa = telefone;
    }
    public String getNumero(){
        return this.numeroEmpresa;
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
    public Endereco getEndereco(){
        return this.endereco;
    }
}
