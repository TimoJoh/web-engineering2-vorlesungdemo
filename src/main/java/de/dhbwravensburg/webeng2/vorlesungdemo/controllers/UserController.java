package de.dhbwravensburg.webeng2.vorlesungdemo.controllers;

import de.dhbwravensburg.webeng2.vorlesungdemo.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    private List<User> users = new ArrayList<>(User.testUser());

    @GetMapping("/users")
    public List<User> allUsers() {
        return User.testUser();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
       for (User user : users) {
           if (user.id() == id) {
               return ResponseEntity.ok(user);
           }

       }
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = new User(
                UUID.randomUUID().toString(),
                user.firstName(),
                user.lastName(),
                user.email(),
                user.age(),
                user.isVerified());
        this.users.add(user);
        return ResponseEntity.created();
    }
}
