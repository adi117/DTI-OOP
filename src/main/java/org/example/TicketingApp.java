package org.example;

import java.util.ArrayList;
import java.util.List;

public class TicketingApp {

    public void bookTicket(User user, Event event, int ticketQuantity) {
        int availableTickets = event.getAvailableTicketList().get(event.getEventName());

        if (ticketQuantity > availableTickets) {
            System.out.println("Not enough stock for " + event.getEventName() +
                    ". Only " + availableTickets + " tickets available.");
            return;
        }

        int bookedTickets = 0;

        for (int i = 0; i < ticketQuantity; i++) {
            Ticket ticket = event.getAvailableTicket();
            if (ticket != null && ticket.bookTicket(user)) {
                bookedTickets++;
                ticket.printTicket(i + 1);
            } else {
                System.out.println("Error to book ticket : " + (i + 1));
            }
        }

        if (bookedTickets > 0) {
            event.updateStock(bookedTickets);
            System.out.println("Booking successful! " + bookedTickets + " tickets booked.");
            System.out.println("----------------------");
        } else {
            System.out.println("Booking failed. No available tickets.");
        }
    }

}
