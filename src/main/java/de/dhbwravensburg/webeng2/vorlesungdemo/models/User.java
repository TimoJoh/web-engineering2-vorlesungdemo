package de.dhbwravensburg.webeng2.vorlesungdemo.models;

import java.util.List;

public record User(
        String id,
        String firstName,
        String lastName,
        String email,
        int age,
        boolean isVerified) {

    public static List<User> testUser(){
        return List.of(
                new User(0, "Harry", "Potter", "harry@hogwarts.uk", 11, true),
                new User(1, "Hermine", "Granger", "hermine@hogwarts.uk", 12, false),
                new User(2, "Ron", "Weasley", "ron@hogwarts.uk", 12, true)
        );
    }
}
