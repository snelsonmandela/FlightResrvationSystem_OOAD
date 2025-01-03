package com.company;

public class Passenger {
    private static int idCounter;
    private final int id;
    private final Address address;
    private final Contact contact;

    static{
        idCounter = 0;
    }

    private static class Address {
        private String street;
        private String city;
        private String state;

        public Address(String street, String city, String state) {
            this.street = street;
            this.city = city;
            this.state = state;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getAddressDetails() {
            return "Street : " + this.getStreet() + "\nCity : " + this.getCity() + "\nState : " + this.getState();
        }

        public void updateAddressDetails(Address address) {
            setCity(address.city);
            setState(address.state);
            setStreet(address.street);
        }
    }

    private static class Contact {
        private String name;
        private String phone;
        private String email;

        public Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getContactDetails() {
            return "Name : " + this.getName() + "\nPhone : " + this.getPhone()+ "\nEmail : " + this.getEmail();
        }

        public void updateContactDetails(Contact contact) {
            setEmail(contact.email);
            setName(contact.name);
            setPhone(contact.phone);
        }
    }
    public Passenger(String name, String phone, String email, String street, String city, String state) {
        this.id = ++idCounter;
        this.contact = new Contact(name,phone,email);
        this.address = new Address(street,city,state);
    }

    public int getID() {
        return id;
    }

    public String getPassengerDetails(){
        return "PassengerId : "+ this.getID() +"\n"+ this.contact.getContactDetails() +"\n"+ this.address.getAddressDetails();
    }

    public int getPassengerCount(){
        return idCounter;
    }
//    public void setName(String name){
//        if(name != null){
//            this.contact.name = name;
//        }
//    }
//
//    public void setPhone(String phone){
//        if(phone.length() == 10){
//            this.contact.phone = phone;
//        }
//    }
//
//    public void setEmail(String email){
//        if(email != null){
//            this.contact.email = email;
//        }
//    }
//
//    public void setContactDetails(Contact contact){
//        this.contact.updateContactDetails(contact);
//    }
//
//    public void setStreet(String street){
//        if(street != null){
//            this.address.street = street;
//        }
//
//    }
//
//    public void setCity(String city){
//        if(city != null){
//            this.address.city = city;
//        }
//
//    }
//
//    public void setState(String state){
//        if(state != null){
//            this.address.state = null;
//        }
//    }
//
//    public void setAddressDetails(Address address){
//        this.address.updateAddressDetails(address);
//    }
}
