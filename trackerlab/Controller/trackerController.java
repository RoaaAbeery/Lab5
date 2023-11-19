package com.example.trackerlab.Controller;

import com.example.trackerlab.tracker.Tracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Tracker")
public class trackerController {

    ArrayList<Tracker> tracks =new ArrayList<>();
    @PostMapping("/addtracker")
    public String addStudent(@RequestBody Tracker track){
        tracks.add(track);
        return "project add";
    }
    @GetMapping("/Display")
    public ArrayList<Tracker> Display(){
        return tracks;
    }
@PutMapping("/update/{index}")
    public String update (@PathVariable int index ,@RequestBody Tracker track){
        tracks.set(index,track);
        return "project updated";
}
@DeleteMapping("/Delete/{index}")
    public String delete(@PathVariable int index ){
        tracks.remove(index);
        return "project deleted";

}
@PutMapping("/Status/{index}")
    public String status(@PathVariable int index ){
        Tracker tracke=tracks.get(index);
        if(tracke.getStatus().equals("not done")){
            tracke.setStatus("done");
            tracks.set(index,tracke);
        }
        if(tracke.getStatus().equals("done")){
            tracke.setStatus("not done");
            tracks.set(index,tracke);
        }
        return "Status changed";
}

 @GetMapping("/Search/{title}")
    public String search (@PathVariable String title){
        for (Tracker tracke: tracks){
            if(tracke.getTitle().equals(title))
                return "The project found : "+tracke;
        }
    return "The project found";
}
@GetMapping("/CompanyName/{name}")
    public String companyName(@PathVariable String name){
        for (Tracker tracke:tracks){
            if (tracke.getCompanyName().equals(name))
                return "The project found :"+ tracke;
        }
    return "The project found ";
}

}
