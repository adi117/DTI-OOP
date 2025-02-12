package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Event film1 = new Event("SuperBowl", 20, 25000);
        Event film2 = new Event("World Cup", 10, 30000);
        Event film3 = new Event("F1", 15, 25000);

        TicketingApp app = new TicketingApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Event.displayAvailableEvent();
            System.out.print("Enter username (type 'q' to quit): ");
            String userName = scanner.nextLine();
            if (userName.equalsIgnoreCase("q")) break;

            User user = new User(userName);

            String eventName = "";

            Event selectedEvent = null;
            while (selectedEvent == null) {
                try {
                    System.out.print("Enter the event name / number: ");
                    eventName = scanner.nextLine().toUpperCase();

                    if (eventName.equalsIgnoreCase("SuperBowl")) {
                        selectedEvent = film1;
                    } else if (eventName.equalsIgnoreCase("World Cup")) {
                        selectedEvent = film2;
                    } else if (eventName.equalsIgnoreCase("F1")) {
                        selectedEvent = film3;
                    } else {
                        throw new IllegalArgumentException("Invalid event name. Please try again.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            int ticketQuantity = 0;

            while (true){
                try {
                    System.out.print("Enter the number of tickets you want to buy: ");
                    ticketQuantity = scanner.nextInt();

                    if (ticketQuantity < 1){
                        throw new IllegalArgumentException("Amount must be more than 0!");
                    } else if (ticketQuantity > selectedEvent.getAvailableTicketList().get(eventName)){
                        throw new IllegalArgumentException("Amount cannot greater than ticket stock!");
                    }

                    break;

                } catch (InputMismatchException e){
                    System.out.println("Input should be a number!");
                    scanner.nextLine();
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }

            try {
                if (selectedEvent.checkTicketAvailability(eventName)) {
                    double totalPrice = selectedEvent.getTicketPrice() * ticketQuantity;
                    System.out.println("Total Price: " + totalPrice);
                    System.out.print("Confirm purchase? (Y/N): ");
                    String confirmation;

                    scanner.nextLine();

                    confirmation = scanner.nextLine();

                    if (confirmation.equalsIgnoreCase("Y")) {
                        app.bookTicket(user, selectedEvent, ticketQuantity);
                    } else {
                        System.out.println("Ticket purchasing cancelled");
                    }
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        scanner.close();
    }
}