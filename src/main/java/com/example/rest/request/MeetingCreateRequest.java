package com.example.rest.request;

import java.time.LocalDateTime;

public class MeetingCreateRequest {

    private String attendeeUsername;

    private LocalDateTime meetingDateTime;

    private String city;

    private String zipCode;

    private String street;

    public MeetingCreateRequest() {
    }

    public String getAttendeeUsername() {
        return attendeeUsername;
    }

    public void setAttendeeUsername(String attendeeUsername) {
        this.attendeeUsername = attendeeUsername;
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
