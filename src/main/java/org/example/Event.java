package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Event {
    private static final HashMap<String, Integer> availableTicketList = new HashMap<>();
    private final String eventName;
    private final List<Ticket> ticket;
    private final double ticketPrice;

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

        int numberOrder = 0;

        for (String event : availableTicketList.keySet()) {
            numberOrder++;
            System.out.println(numberOrder + ". "+ event + " - Tickets available: " + availableTicketList.get(event));
        }
    }

    public void updateStock(int ticketBought){
        availableTicketList.put(eventName, availableTicketList.get(eventName) - ticketBought);
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
