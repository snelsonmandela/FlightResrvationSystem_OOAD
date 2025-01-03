package com.company;

public class Flight {
    private final String FLIGHT_ID;
    private final String AIRLINE_COMPANY_NAME;
    private final int TOTAL_CAPACITY;
    private int bookedSeats;

    public void decrementBookedSeats() {
        this.bookedSeats--;
    }

    public Flight(String AIRLINE_COMPANY_NAME, int TOTAL_CAPACITY) {
        int random = (int) (Math.random() * 9999);
        if (random < 1000) {
            random += 1000;
        }
        this.AIRLINE_COMPANY_NAME = AIRLINE_COMPANY_NAME;
        this.FLIGHT_ID = this.AIRLINE_COMPANY_NAME.substring(0, 2).toUpperCase() + random; //FlightID is of the format "[A-Z][A-Z][4 digits]"
        this.TOTAL_CAPACITY = TOTAL_CAPACITY;
        this.bookedSeats = 0;
    }

    public String getFLIGHT_ID() {
        return this.FLIGHT_ID;
    }

    public String getAIRLINE_COMPANY_NAME() {
        return this.AIRLINE_COMPANY_NAME;
    }

    public int numberOfSeatsAvailable() {
        return this.TOTAL_CAPACITY - this.bookedSeats;
    }

    public void updateAvailableSeats() {
        if (numberOfSeatsAvailable() == 0) {
            System.out.println("All seats booked.");
            return;
        }
        this.bookedSeats++; //statement isn't accessed if all seats are booked
    }

    public String getFlightDetails() {
        return "FlightId : " + this.getFLIGHT_ID() + "\nCompany : " + this.getAIRLINE_COMPANY_NAME() +
                "\nFlight Capacity : " + this.getTOTAL_CAPACITY() + "\nBookedSeats : " + this.getBookedSeats();
    }

    public int getTOTAL_CAPACITY() {
        return TOTAL_CAPACITY;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }
}
