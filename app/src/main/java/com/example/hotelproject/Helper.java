package com.example.hotelproject;

public class Helper {
    String name, contact, checkIn, checkOut, persons, room;

    public Helper(String NAME, String CONTACT, String PERSONS, String IN, String OUT) {

    }

    public Helper(String name, String contact, String checkIn, String checkOut, String persons, String room) {
        this.name = name;
        this.contact = contact;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.persons = persons;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getPersons() {
        return persons;
    }

    public void setPersons(String persons) {
        this.persons = persons;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
