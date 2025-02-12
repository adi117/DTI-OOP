package org.example;

import java.util.ArrayList;
import java.util.List;

public class TicketingApp {
    private List<String> eventList = new ArrayList<>();
    private List<String> registeredUser = new ArrayList<>();

    public List<String> getEventList() {
        return eventList;
    }

    public void setEventList(List<String> eventList) {
        this.eventList = eventList;
    }
}
