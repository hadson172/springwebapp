package com.example.rest.response;

import java.time.LocalDateTime;

public class MeetingResponse {

    private Long id;

    private String attendee;

    private LocalDateTime meetingDateTime;

    private String city;

    private String zipCode;

    private String street;

    public MeetingResponse(Long id, String attendee, LocalDateTime meetingDateTime, String city, String zipCode, String street) {
        this.id = id;
        this.attendee = attendee;
        this.meetingDateTime = meetingDateTime;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttendee() {
        return attendee;
    }

    public void setAttendee(String attendee) {
        this.attendee = attendee;
    }

    public LocalDateTime getMeetingDateTime() {
        return meetingDateTime;
    }

    public void setMeetingDateTime(LocalDateTime meetingDateTime) {
        this.meetingDateTime = meetingDateTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
