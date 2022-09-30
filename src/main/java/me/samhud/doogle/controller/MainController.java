package me.samhud.doogle.controller;

import me.samhud.doogle.entities.*;
import me.samhud.doogle.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    ShelterRepository shelters;

    @Autowired
    DogRepository dogs;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("shelters", shelters.findAll());
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @PostMapping("/addShelter")
    public String addShelter(Shelter shelter) {
        shelters.save(shelter);
        return "redirect:/";
    }

    @GetMapping("/viewShelter")
    public String viewShelter(Integer id, Model model) {
        Shelter shelter = shelters.findById(id).orElse(null);
        List<Dog> dogList = dogs.findByShelter(shelter);

        model.addAttribute("shelter", shelter);
        model.addAttribute("dogs", dogList);

        return "shelter";
    }

    @PostMapping("/addDog")
    public String addDog(Dog dog, HttpServletRequest request) {
        int shelterid = Integer.parseInt(request.getParameter("shelterid"));
        Shelter shelter = shelters.findById(shelterid).orElse(null);
        dog.setShelter(shelter);

        dogs.save(dog);
        return "redirect:/viewShelter?id=" + shelterid;
    }

    @GetMapping("/deleteDog")
    public String deleteProduct(Integer id, Integer shelterid) {
        dogs.deleteById(id);
        return "redirect:/viewShelter?id=" + shelterid;
    }
}
