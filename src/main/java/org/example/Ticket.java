package org.example;

import java.util.List;

public class Ticket {
    private int ticketID;
    private int ticketStock;
    private int seatNumber;
    private double ticketPrice;
    private String eventName;

    public Ticket(){}
    public Ticket(String eventName,double ticketPrice, int seatNumber, int ticketStock){
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
        this.ticketStock = ticketStock;
        this.seatNumber = seatNumber;
    }

    public int getTicketID () {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getTicketStock () {
        return ticketStock;
    }

    public void setTicketStock(int ticketStock) {
        this.ticketStock = ticketStock;
    }

    public double getTicketPrice () {
        return ticketStock;
    }

    public void setTicketPrice(int ticketPrice) {
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

}
