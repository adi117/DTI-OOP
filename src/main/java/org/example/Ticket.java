package org.example;

import java.util.List;
import java.util.UUID;

public class Ticket {
    private final String ticketID;
    private int ticketStock;
    private int seatNumber;
    private double ticketPrice;
    private String eventName;

    public Ticket(String eventName,double ticketPrice, int seatNumber, int ticketStock){
        this.ticketID = UUID.randomUUID().toString();
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
        this.ticketStock = ticketStock;
        this.seatNumber = seatNumber;
    }

    public String getTicketID () {
        return ticketID;
    }

    public int getTicketStock () {
        return ticketStock;
    }

    public void setTicketStock(int ticketStock) {
        this.ticketStock = ticketStock;
    }

    public double getTicketPrice () {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getSeatNumber () {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getEventName () {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName= eventName;
    }

    public void buyTicket(){

    }

    public void updateTicketStock(){

    }

}
