package com.soldagor.airport_manager;

import java.util.Date;

public class Flight {
    String nameFlight;              //FL-123
    String destinationFlight;       //Maldive
    Date departureDate;             //when take off
    int flightDuration;             //in sec
    int maxUserCapacity;            //max nr. of passengers
    StatusFlightEnum statusFlight;  //scheduled, canceled, finished


}
