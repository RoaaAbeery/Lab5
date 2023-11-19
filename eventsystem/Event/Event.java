package com.example.eventsystem.Event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Event {
    private String id;
    private String description;
    private double capacity;
    private String startDate;
    private String endDate;
}
