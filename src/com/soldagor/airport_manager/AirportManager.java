package com.soldagor.airport_manager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class AirportManager {

    public static void main(String[] args) {

        //Collection<User> users = new ArrayList<>();
        Collection<Flight> flights = new ArrayList<>();

        var flight1 = new Flight("FL-001",
                "Maldive",
                LocalDateTime.of(2021, 1,26,14, 0, 0),
                8,
                2,
                StatusFlightEnum.SCHEDULED);

        var flight2 = new Flight("FL-002",
                "London",
                LocalDateTime.of(2020, 1,28,7,0,0),
                3,
                100,
                StatusFlightEnum.SCHEDULED);

        var flight3 = new Flight("FL-003",
                "Munich",
                LocalDateTime.of(2020, 1,26,9,0,0),
                2,
                10,
                StatusFlightEnum.SCHEDULED);

        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);

        flights.forEach(System.out::println);

        var user1 = new User("S", "George", LocalDate.of(1980, 3, 19));
        var user2 = new User("D", "Diana", LocalDate.of(1990, 2, 18));
        var user3 = new User("P", "Anca", LocalDate.of(1991, 1, 11));

        System.out.println("flight1 | users");
        try {
            flight1.addUser(user1);
            flight1.addUser(user2);
            flight1.addUser(user3);
        } catch (DuplicateNameException e) {
            e.printStackTrace();
        }

        System.out.println();

        System.out.println("flight2 | users");
        try {
            flight2.addUser(user1);
            flight2.addUser(user3);
        } catch (DuplicateNameException e) {
            e.printStackTrace();
        }

        System.out.println();

        System.out.println("flight3 | users");
        try {
            flight3.addUser(user1);
        } catch (DuplicateNameException e) {
            e.printStackTrace();
        }

        System.out.println();

        System.out.println("Flight 1 - users joined");
        flight1.users.forEach(System.out::println);
        System.out.println();

        System.out.println("Flight 2 - users joined");
        flight2.users.forEach(System.out::println);
        System.out.println();

        System.out.println("Flight 3 - users joined");
        flight3.users.forEach(System.out::println);

        System.out.println();
        System.out.println("Flights for user1");
        flights
                .stream()
                .filter(flight -> flight.users.contains(user1))
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Flights for user2");
        flights
                .stream()
                .filter(flight -> flight.users.contains(user2))
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Flights for user3");
        flights
                .stream()
                .filter(flight -> flight.users.contains(user2))
                .forEach(System.out::println);

        System.out.println("Removed flight3");
        flights.remove(flight3);

        System.out.println("Print all remaining flights");
        flights.forEach(System.out::println);

        System.out.println("Removed user3");
        flight1.removeUser(user3);

        System.out.println("Remove user1 from flight1");
        flight1.users.remove(user1);

        System.out.println("Print all remaining users for flight1");
        flight1.users.forEach(System.out::println);

        System.out.println("Print all remaining users");
        flight1.users.forEach(System.out::println);

        flights.forEach(Flight::updateStatus);

        flights.forEach(flight -> System.out.println(flight.statusFlight));

        flights
                .stream()
                .filter(flight -> flight.statusFlight.equals(StatusFlightEnum.FINISHED))
                .forEach(System.out::println);

    }
}
