package com.example.rest.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class MeetingCreateRequest {

    @NotNull
    @NotBlank
    private String attendeeUsername;

    @NotNull
    private LocalDateTime meetingDateTime;

    @NotNull
    @NotBlank
    private String city;

    @NotNull
    @NotBlank
    private String zipCode;

    @NotNull
    @NotBlank
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
