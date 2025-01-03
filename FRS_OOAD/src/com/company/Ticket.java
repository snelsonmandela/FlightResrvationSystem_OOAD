package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class Ticket {
    private final String PNR;
    private final String DEPARTURE_LOCATION;
    private final String DESTINATION_LOCATION; //making all these attributes final because once a ticket is booked
    private final String DEPARTURE_DATE_AND_TIME;// it can only be cancelled and not updated
    private final String DESTINATION_ARRIVAL_DATE_AND_TIME;
    private final String SEAT_NUMBER;
    private final float TICKET_PRICE;
    private final Flight flightDetails;
    private final Passenger passengerDetails;
    private enum TicketStatus {
        CONFIRMED, CANCELLED
    }
    private TicketStatus status;

    public Ticket(String PNR, String DEPARTURE_LOCATION, String DESTINATION_LOCATION, String DEPARTURE_DATE_AND_TIME,
                  String DESTINATION_ARRIVAL_DATE_AND_TIME, String SEAT_NUMBER, float TICKET_PRICE, Flight flightDetails,
                  Passenger passengerDetails) {
        this.PNR = PNR;
        this.DEPARTURE_LOCATION = DEPARTURE_LOCATION;
        this.DESTINATION_LOCATION = DESTINATION_LOCATION;
        this.DEPARTURE_DATE_AND_TIME = DEPARTURE_DATE_AND_TIME;
        this.DESTINATION_ARRIVAL_DATE_AND_TIME = DESTINATION_ARRIVAL_DATE_AND_TIME;
        this.SEAT_NUMBER = SEAT_NUMBER;
        this.TICKET_PRICE = TICKET_PRICE;
        this.flightDetails = flightDetails;
        this.passengerDetails = passengerDetails;
        this.status = TicketStatus.CONFIRMED;
        this.flightDetails.updateAvailableSeats();
    }


    public String getFlightDetails() {
        return this.flightDetails.getFlightDetails();
    }

    public String getPassengerDetails() {
        return this.passengerDetails.getPassengerDetails();
    }

    public String getPNR() {
        return PNR;
    }

    public String getDEPARTURE_LOCATION() {
        return DEPARTURE_LOCATION;
    }


    public String getDESTINATION_LOCATION() {
        return DESTINATION_LOCATION;
    }


    public String getDEPARTURE_DATE_AND_TIME() {
        return DEPARTURE_DATE_AND_TIME;
    }

    public String getDESTINATION_ARRIVAL_DATE_AND_TIME() {
        return DESTINATION_ARRIVAL_DATE_AND_TIME;
    }


    public String getSEAT_NUMBER() {
        return SEAT_NUMBER;
    }


    public float getTICKET_PRICE() {
        return TICKET_PRICE;
    }

    public void cancelTicket() {
        this.status = TicketStatus.CANCELLED;
        this.flightDetails.decrementBookedSeats();
    }

    public String journeyDuration() { //code reference geeksforgeeks
        // SimpleDateFormat converts the
        // string format to date object
        String returnString = null;
        SimpleDateFormat sdf
                = new SimpleDateFormat(
                "dd-MM-yyyy HH:mm:ss");
        try {
            // parse method is used to parse
            // the text from a string to
            // produce the date
            Date d1 = sdf.parse(this.DEPARTURE_DATE_AND_TIME);
            Date d2 = sdf.parse(this.DESTINATION_ARRIVAL_DATE_AND_TIME);

            // Calculate time difference
            // in milliseconds
            returnString = getDifferenceInTime(d1, d2);
        } catch (Exception e) {
            e.printStackTrace();
            returnString = "Please Enter a valid data and time format";
        }
        return returnString;
    }

    private static String getDifferenceInTime(Date d1, Date d2) {
        long difference_In_Time = d2.getTime() - d1.getTime();
        long difference_In_Minutes = TimeUnit.MILLISECONDS.toMinutes(difference_In_Time) % 60;
        long difference_In_Hours = TimeUnit.MILLISECONDS.toHours(difference_In_Time) % 24;
        long difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time) % 365;
        return ": " + difference_In_Days + " Days, " + difference_In_Hours + " Hours, "
                + difference_In_Minutes + " Minutes";
    }

    public TicketStatus getTicketStatus() {
        return this.status;
    }

    public String getTicketDetails(){
        return "PNR : "+ this.getPNR() + "\nDeparture : " + this.getDEPARTURE_LOCATION()+
                "\nDestination : "+ getDESTINATION_LOCATION() + "\nDepartureTime : "+
                this.getDEPARTURE_DATE_AND_TIME() + "\nDestinationArrivalTime : " +
                this.getDESTINATION_ARRIVAL_DATE_AND_TIME() + "\nJourney Duration "+this.journeyDuration()+
                "\nSeat Number : " + this.getSEAT_NUMBER() + "\nTicketPrice : " + this.getTICKET_PRICE() +
                "\nStatus : "+ this.getTicketStatus();
    }
}
