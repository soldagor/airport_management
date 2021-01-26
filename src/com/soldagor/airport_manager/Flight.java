package com.soldagor.airport_manager;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class Flight {
    String nameFlight;              //FL-123
    String destinationFlight;       //Maldive
    LocalDateTime departureDate;    //when take off
    int flightDuration;             //in sec
    int maxUserCapacity;            //max nr. of passengers
    StatusFlightEnum statusFlight;  //scheduled, canceled, finished
    int countUsers;                 //users count

    Collection<User> users = new ArrayList<>();

    public Flight(String nameFlight,
                  String destinationFlight,
                  LocalDateTime departureDate,
                  int flightDuration,
                  int maxUserCapacity,
                  StatusFlightEnum statusFlight) {
        this.nameFlight = nameFlight;
        this.destinationFlight = destinationFlight;
        this.departureDate = departureDate;
        this.flightDuration = flightDuration * 3600;
        this.maxUserCapacity = maxUserCapacity;
        this.statusFlight = statusFlight;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "nameFlight='" + nameFlight + '\'' +
                ", destinationFlight='" + destinationFlight + '\'' +
                ", departureDate=" + departureDate +
                ", flightDuration=" + flightDuration +
                ", maxUserCapacity=" + maxUserCapacity +
                ", statusFlight=" + statusFlight +
                '}';
    }

    public void addUser(User user) throws DuplicateNameException {
        if (countUsers < maxUserCapacity) {
            if (users.contains(user)) {
                throw new DuplicateNameException("duplicate user= " + user);
            }
            users.add(user);
            countUsers++;
            System.out.println("user=" + users.size() + " | count=" + countUsers);

        } else {
            System.out.println("no user capacity");
        }
    }

    public void removeUser(User user) {
        users.remove(user);
        countUsers--;
        System.out.println("user=" + users.size() + " | count=" + countUsers);
    }

    public void updateStatus() {
        if (statusFlight.equals(StatusFlightEnum.SCHEDULED)) {

            ZoneOffset zoneOffset = ZoneOffset.UTC;
            var initialDate = departureDate.toEpochSecond(zoneOffset);
            Instant instant = Instant.now();
            var currentDate = instant.getEpochSecond();
            var durationFlightLong = Long.valueOf(flightDuration);
            var total = initialDate + durationFlightLong;

            System.out.println(initialDate);
            System.out.println(currentDate);
            if (currentDate > total) {
                statusFlight = StatusFlightEnum.FINISHED;
            }
        }

    }
}
