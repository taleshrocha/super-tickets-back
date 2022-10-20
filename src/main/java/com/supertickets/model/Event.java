package com.supertickets.model;

public class Event {
    private long id;
    private long eventOwnerId;
    private String name;
    private String adress;
    // TODO: create tickets arrey.

    public Event(long id, String name) {
        this.id = id;
        this.name = name;
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
