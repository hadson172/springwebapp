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
    private User initiator;

    @ManyToOne
    private User attendee;

    private LocalDateTime meetingDateTime;

    private Address address;

    private LocalDateTime timestamp;

    private boolean accepted;


    public Meeting() {
    }

    public Meeting(User initiator, User attendee, LocalDateTime meetingDateTime, Address address) {
        this.initiator = initiator;
        this.attendee = attendee;
        this.meetingDateTime = meetingDateTime;
        this.address = address;
    }

    @PrePersist
    public void setTimestamp() {
        this.timestamp = LocalDateTime.now();
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public Long getId() {
        return id;
    }

    public User getInitiator() {
        return initiator;
    }

    public void setInitiator(User client) {
        this.initiator = client;
    }

    public User getAttendee() {
        return attendee;
    }

    public void setAttendee(User attendee) {
        this.attendee = attendee;
    }

    public LocalDateTime getMeetingDateTime() {
        return meetingDateTime;
    }

    public void setMeetingDateTime(LocalDateTime meetingDateTime) {
        this.meetingDateTime = meetingDateTime;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
