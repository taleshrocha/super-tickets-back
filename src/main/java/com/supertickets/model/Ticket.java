package com.supertickets.model;

public class Ticket{
    private int id;
    private double value;
    private int ownerTicket;

    public Ticket(int id, double value){
        this.setID(id);
        this.setValue(value);
    }

    public void setID(int id){
        this.id = id;
    }
    public int getID(){
        return this.id;
    }

    public void setValue(double value){
        this.value = value;
    }
    public double getValue(){
        return this.value;
    }
    
    public void setOwner(int owenerID){
        this.ownerTicket = owenerID;
    }
    public int getOwner(){
        return this.ownerTicket;
    }
}

