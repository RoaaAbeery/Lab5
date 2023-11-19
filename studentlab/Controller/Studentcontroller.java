package com.example.studentlab.Controller;

import com.example.studentlab.Model.Model;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.Name;
import java.util.ArrayList;

@RestController
@RequestMapping("/Student")
public class Studentcontroller {
    ArrayList<Model> students=new ArrayList<>();

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Model Student){
        students.add(Student);
        return "student add";
    }
    @GetMapping("/name/{index}")
        public String name(@PathVariable int index ){
        return students.get(index).getName();
    }
    @GetMapping("/age/{index}")
    public int age(@PathVariable int index ){
        return students.get(index).getAge();
    }
    @GetMapping("/college/degree/{index}")
    public String dgree(@PathVariable int index){
        return students.get(index).getDegree();
    }
    @GetMapping("/status/{index}")
    public boolean status (@PathVariable int index) {

        if (students.get(index).getStudy().equals("graduated")) {
            return true;
        }

        else return false;
    }

    @GetMapping("/Students")
    public ArrayList<Model> getTasks() {
        return students;
    }

}

