package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Event {
    private HashMap<String, Integer> availableTicketList = new HashMap<>();
    private String eventName;
    private int ticketStock;

    public Event(){}

    public boolean checkTicketAvailability(String eventName){
        if (availableTicketList.get(eventName) == null){
            throw new IllegalArgumentException("There is no such event!");
        }

        if (availableTicketList.get(eventName) > 0){
            return true;
        } else {
            throw new IllegalArgumentException("The ticket for this event is sold out! Try another event!");
        }
    }

}
