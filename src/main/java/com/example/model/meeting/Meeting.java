package com.example.model.meeting;

import com.example.model.account.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Meeting {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User client;

    @ManyToOne
    private User employee;

    private LocalDateTime meetingDateTime;

    private String meetingPlace;

    private LocalDateTime timestamp;

    public Meeting() {
    }

    public Meeting(User client, User employee, LocalDateTime meetingDateTime, String meetingPlace) {
        this.client = client;
        this.employee = employee;
        this.meetingDateTime = meetingDateTime;
        this.meetingPlace = meetingPlace;
    }

    @PrePersist
    public void setTimestamp(){
        this.timestamp = LocalDateTime.now();
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public LocalDateTime getMeetingDateTime() {
        return meetingDateTime;
    }

    public void setMeetingDateTime(LocalDateTime meetingDateTime) {
        this.meetingDateTime = meetingDateTime;
    }

    public String getMeetingPlace() {
        return meetingPlace;
    }

    public Long getId() {
        return id;
    }

    public void setMeetingPlace(String meetingPlace) {
        this.meetingPlace = meetingPlace;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
