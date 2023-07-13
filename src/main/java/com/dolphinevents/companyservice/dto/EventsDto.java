package com.dolphinevents.companyservice.dto;

import java.sql.Timestamp;

public class EventsDto {

    public EventsDto(){

    }

    private Integer id;
    private String name;
    private String location;
    private Timestamp date;
    private double price;
    private String eventType;

    /*private List<EventsDto> allEvents; */

    public EventsDto(Integer id, String name, String location, Timestamp date, double price, String eventType) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.date = date;
        this.price = price;
        this.eventType = eventType;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getEventType() {
        return eventType;
    }
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    
}
