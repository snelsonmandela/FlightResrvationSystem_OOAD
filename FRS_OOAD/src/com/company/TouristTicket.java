package com.company;

import java.util.Arrays;

public class TouristTicket extends Ticket {

    private String hotelAddress;
    private String[] selectedTouristLocations;

    public TouristTicket(String PNR, String DEPARTURE_LOCATION, String DESTINATION_LOCATION, String DEPARTURE_DATE_AND_TIME,
                         String DESTINATION_ARRIVAL_DATE_AND_TIME, String SEAT_NUMBER, float TICKET_PRICE, String hotelAddress,
                         String[] selectedTouristLocations,Flight flightDetails,Passenger passengerDetails) {
        super(PNR,DEPARTURE_LOCATION,DESTINATION_LOCATION,DEPARTURE_DATE_AND_TIME,DESTINATION_ARRIVAL_DATE_AND_TIME,
                SEAT_NUMBER,TICKET_PRICE,flightDetails,passengerDetails);
        this.hotelAddress = hotelAddress;
        this.selectedTouristLocations = selectedTouristLocations;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public void removeTouristLocation(String location) {
        for(int i = 0 ; i < this.selectedTouristLocations.length; i++){
            if(this.selectedTouristLocations[i]!= null){
                if(this.selectedTouristLocations[i].equals(location)){
                    this.selectedTouristLocations[i] = null; //Deleting the location my making it null in the list
                }
            }

        }
    }

    public void addTouristLocation(String location) {
        int nullCount = 0;
        for (String loc : this.selectedTouristLocations) {
            if (loc == null) nullCount++;
        }
        if (nullCount == 0) {
            System.out.println("Already Selected 5 locations. Cannot add more location. Remove selected locations to add location");
        }else{
            for (int i = 0 ; i < this.selectedTouristLocations.length; i++) {
                if (this.selectedTouristLocations[i] == null) {
                    this.selectedTouristLocations[i] = location;
                    break;
                }
            }
        }
    }

    public String getSelectedTouristLocations() {
        int nullCount = 0;
        StringBuilder stringArray = new StringBuilder();
        for (String loc : this.selectedTouristLocations) {
            if (loc == null) nullCount++;
        }
        if(nullCount == this.selectedTouristLocations.length){
            return "None";

        }else{
            for(int i = 0 ; i < this.selectedTouristLocations.length ; i++){
                if(this.selectedTouristLocations[i] != null){
                    stringArray.append(this.selectedTouristLocations[i] + " ");
                }
            }
            return stringArray.toString();
        }
    }


    @Override
    public String getTicketDetails(){
        return "PNR : "+ this.getPNR() + "\nDeparture : " + this.getDEPARTURE_LOCATION()+
                "\nDestination : "+ getDESTINATION_LOCATION() + "\nDepartureTime : "+
                this.getDEPARTURE_DATE_AND_TIME() + "\nDestinationArrivalTime : " +
                this.getDESTINATION_ARRIVAL_DATE_AND_TIME() + "\nJourney Duration "+this.journeyDuration()+
                "\nSeat Number : " + this.getSEAT_NUMBER() + "\nTicketPrice : " + this.getTICKET_PRICE() +
                "\nHotel Location : "+this.getHotelAddress()+"\nSelected Locations : " + this.getSelectedTouristLocations() + "\nStatus : "+
                this.getTicketStatus();
    }

    public void printSelectedTouristLocations() {
        System.out.println("Locations selected to visit are : ");
        int nullCount = 0;
        for (String loc : this.selectedTouristLocations) {
            if (loc == null) nullCount++;
        }
        if(nullCount == this.selectedTouristLocations.length){
            System.out.println("No locations Selected");

        }else{
            for (String loc : this.selectedTouristLocations) {
                if (loc != null){
                    System.out.print(loc + " ");
                }

            }
            System.out.println();
        }

    }

}
