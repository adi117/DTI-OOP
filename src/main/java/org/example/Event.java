package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Event {
    private static HashMap<String, Integer> availableTicketList = new HashMap<>();
    private String eventName;
    private List<Ticket> ticket;
    private double ticketPrice;

    public Event(String eventName, int ticketStock, double ticketPrice){
        this.eventName = eventName.toUpperCase();
        this.ticket = new ArrayList<>();
        this.ticketPrice = ticketPrice;
        availableTicketList.put(eventName.toUpperCase(), ticketStock);

        for (int i = 0; i < ticketStock; i++) {
            this.ticket.add(new Ticket(this.eventName, this.ticketPrice, i + 1));
        }

    }

    public boolean checkTicketAvailability(String eventName){
        if (availableTicketList.get(eventName.toUpperCase()) == null){
            throw new IllegalArgumentException("There is no such event!");
        }

        if (availableTicketList.get(eventName.toUpperCase()) > 0){
            return true;
        } else {
            throw new IllegalArgumentException("The ticket for this event is sold out! Try another event!");
        }
    }

    public static void displayAvailableEvent(){
        System.out.println("Available Events:");
        for (String event : availableTicketList.keySet()) {
            System.out.println(event + " - Tickets available: " + availableTicketList.get(event));
        }
    }

    public HashMap<String, Integer> updateStock(int ticketBought){
        availableTicketList.put(eventName, availableTicketList.get(eventName) - ticketBought);
        return availableTicketList;
    }

    public Ticket getAvailableTicket() {
        for (Ticket tickets : ticket) {
            if (!tickets.getIsTicketBooked()) {
                return tickets;
            }
        }
        return null;
    }

    public double getTicketPrice(){
        return ticketPrice;
    }

    public String getEventName(){
        return eventName;
    }

    public HashMap<String, Integer> getAvailableTicketList(){
        return availableTicketList;
    }

}
