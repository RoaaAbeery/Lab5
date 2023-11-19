package com.example.trackerlab.tracker;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tracker {
    private String id;
    private String title;
    private String description;
    private String status;
    private String companyName;

}
