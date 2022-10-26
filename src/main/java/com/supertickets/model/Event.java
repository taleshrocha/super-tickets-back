package com.supertickets.model;

import java.util.ArrayList;

public class Event {
    private long id;
    private long eventOwnerId;
    private String name;
    private String adress;
    private ArrayList<Ticket> tickets;

    public Event(long id, String name) {
        this.id = id;
        this.name = name;
        tickets = new ArrayList<Ticket>();
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public long getEventOwnerId() {
        return eventOwnerId;
    }

    public long getId() {
        return id;
    }
}
