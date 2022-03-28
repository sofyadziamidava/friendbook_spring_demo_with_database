package com.example.friendbook_spring_demo.controllers;

import com.example.friendbook_spring_demo.models.Friend;
import com.example.friendbook_spring_demo.repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path="/demo")
public class MainController {

    @Autowired
    private FriendRepository fr;

    @RequestMapping("/add")
    public String addNewKompis (@RequestParam String name, @RequestParam String adress,
                                @RequestParam String email, @RequestParam String phoneNumber) {
        Friend f = new Friend();
        f.setName(name);
        f.setAdress(adress);
        f.setEmail(email);
        f.setPhoneNumber(phoneNumber);
        fr.save(f);
        return "Saved";
    }

    @RequestMapping("/all")
    public Iterable<Friend> getAllKompisar() {
        return fr.findAll();
    }

    @RequestMapping("/getByName")
    public Iterable<Friend> getFriendByName(@RequestParam String name){
        return fr.findByName(name);
    }

    @RequestMapping("/getByNumber")
    public Iterable<Friend> getFriendByNumber(@RequestParam String number){
        return fr.findByPhoneNumber(number);
    }

    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        fr.deleteById(id);
        return "Friend was deleted";
    }

    @RequestMapping("/updateNumber")
    public String updateNumber(@RequestParam Long id, @RequestParam String number) {
        Friend f = fr.findById(id).get();
        f.setPhoneNumber(number);
        fr.save(f);
        return "Phone number updated!";
    }

    @RequestMapping("/updateAdress")
    public String updateAdress(@RequestParam Long id, @RequestParam String adress){
        Friend f = fr.findById(id).get();
        f.setAdress(adress);
        fr.save(f);
        return "Adress updated!";
    }

    @RequestMapping("/updateEmail")
    public String updateEmail(@RequestParam Long id, @RequestParam String email){
        Friend f = fr.findById(id).get();
        f.setAdress(email);
        fr.save(f);
        return "Email updated!";
    }

}
