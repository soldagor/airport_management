package com.soldagor.airport_manager;

import java.time.LocalDate;

public class User {
    String firstName;
    String lastName;
    LocalDate birthDate;
    int countUsers;                 //users count


    public User(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

}
