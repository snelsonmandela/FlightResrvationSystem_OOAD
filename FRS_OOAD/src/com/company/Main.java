package com.company;


import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

        // Object creation of all the classes
        Passenger passenger = new Passenger( "Rakshith", "7019032719", "rakshithg35@gmail",
                "4th Cross", "Bengaluru", "Karnataka");
        Passenger passenger2 = new Passenger( "Rakshitha", "7019032713", "rakshithag35@gmail",
                "4th Cross", "Bengaluru", "Karnataka");

        Flight flightRegular = new Flight("Air India",100);
        Flight flightTourist = new Flight("Deccan Airline",100);

        Ticket regularTicket = new RegularTicket("AB7DE", "Bengaluru",
                "Delhi", "03-03-2021 01:10:20",
                "04-03-2021 02:20:40", "A8", 2209.50f,flightRegular
                ,passenger, "food, water, snacks");

        Ticket touristTicket = new TouristTicket("A97DX", "Bengaluru",
                "New York", "03-03-2021 01:10:20",
                "05-03-2021 04:20:40", "A8",5000.0f,
                "DelhiHotel",new String[]{"Taj Mahal","Qutab Minar","Jantar Mantar"},flightTourist,passenger2);

        printTicketDetails(regularTicket);
        printTicketDetails(touristTicket);

    }

    public static void printTicketDetails(Ticket ticket) {
        System.out.println(ticket.getPNR());
    }
}
