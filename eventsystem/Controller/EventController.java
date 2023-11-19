package com.example.eventsystem.Controller;

import com.example.eventsystem.Event.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/event")
public class EventController {
    ArrayList<Event> events =new ArrayList<>();
    @PostMapping("/add")
    public String addTasks(@RequestBody Event event) {
       events.add(event);
       return  "Event add";
    }
    @GetMapping("/Display")
    public ArrayList<Event> getTasks() {
        return events;
    }
    @PutMapping("/update/{index}")
    public String updateTasks(@PathVariable int index, @RequestBody Event event) {
            events.set(index, event);
        return ("Event updated");
    }

    @DeleteMapping("/delete/{index}")
    public String deleteTasks(@PathVariable int index) {
        events.remove(index);
        return "event deleted";
    }

    @PutMapping("/change/{index}")
    public String change(@PathVariable int index,@RequestBody double newCapacity) {
        events.get(index).setCapacity(newCapacity);
      return "Capacity changed";
    }

    @GetMapping("/search/{id}")
    public String search(@PathVariable String id) {
        for (Event event : events) {
            if (event.getId().equals(id))
                return "The Event Found"+event;
        }
        return "Event not Found";

    }
}
