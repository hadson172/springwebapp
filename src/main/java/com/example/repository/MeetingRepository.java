package com.example.repository;

import com.example.model.account.User;
import com.example.model.meeting.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    List<Meeting> findAllByInitiatorOrAttendee(User initiator, User attendee);

    Optional<Meeting> findMeetingById(Long id);
}
