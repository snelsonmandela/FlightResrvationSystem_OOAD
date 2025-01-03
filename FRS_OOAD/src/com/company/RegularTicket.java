package com.company;

public class RegularTicket extends Ticket {

    private String specialServices;

    public RegularTicket(String PNR, String DEPARTURE_LOCATION, String DESTINATION_LOCATION, String DEPARTURE_DATE_AND_TIME,
                         String DESTINATION_ARRIVAL_DATE_AND_TIME, String SEAT_NUMBER, float TICKET_PRICE, Flight flightDetails,
                         Passenger passengerDetails,String specialServices) {
        super(PNR,DEPARTURE_LOCATION,DESTINATION_LOCATION,DEPARTURE_DATE_AND_TIME,DESTINATION_ARRIVAL_DATE_AND_TIME,
                SEAT_NUMBER,TICKET_PRICE,flightDetails,passengerDetails);
        this.specialServices = specialServices;
    }

    public String getSpecialServices() {
        return specialServices;
    }

    @Override
    public String getTicketDetails(){
        return "PNR : "+ this.getPNR() + "\nDeparture : " + this.getDEPARTURE_LOCATION()+
                "\nDestination : "+ getDESTINATION_LOCATION() + "\nDepartureTime : "+
                this.getDEPARTURE_DATE_AND_TIME() + "\nDestinationArrivalTime : " +
                this.getDESTINATION_ARRIVAL_DATE_AND_TIME() +"\nJourney Duration "+this.journeyDuration()+
                "\nSeat Number : " + this.getSEAT_NUMBER() + "\nTicketPrice : " + this.getTICKET_PRICE() +
                "\nSpecial Services : "+this.getSpecialServices()+ "\nStatus : "+ this.getTicketStatus();
    }

    public void setSpecialServices(String specialServices) {
        this.specialServices = specialServices;
    }
}
