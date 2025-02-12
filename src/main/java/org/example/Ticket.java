package org.example;

import java.util.List;
import java.util.UUID;

public class Ticket {
    private final String ticketID;
    private int ticketStock;
    private int seatNumber;
    private double ticketPrice;
    private String eventName;
    private boolean isTicketBooked;
    private User user;

    public Ticket(String eventName,double ticketPrice, int seatNumber, int ticketStock){
        this.ticketID = UUID.randomUUID().toString();
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
        this.ticketStock = ticketStock;
        this.seatNumber = seatNumber;
        this.isTicketBooked = false;
    }

    public boolean getIsTicketBooked(){
        return isTicketBooked;
    }

    public boolean bookTicket(User user){
        if (!isTicketBooked){
            this.isTicketBooked = true;
            this.user = user;
            return true;
        }

        return false;
    }

    public void printTicket(int ticketQuantity) {
        if (isTicketBooked) {
            System.out.println("--- Ticket " + ticketQuantity + " ---");
            System.out.println("Ticket ID: " + ticketID);
            System.out.println("Event: " + eventName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: " + ticketPrice);
            System.out.println("User: " + user.getUserName());
        } else {
            System.out.println("This ticket is not booked yet");
        }
    }

}
