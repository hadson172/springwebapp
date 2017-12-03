package com.example.service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.account.User;
import com.example.model.account.role.Role;
import com.example.model.meeting.Address;
import com.example.model.meeting.Meeting;
import com.example.repository.MeetingRepository;
import com.example.rest.request.MeetingCreateRequest;
import com.example.rest.response.MeetingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeetingService {

    private MeetingRepository meetingRepository;
    private UserService userService;

    @Autowired
    public MeetingService(MeetingRepository meetingRepository, UserService userService) {
        this.meetingRepository = meetingRepository;
        this.userService = userService;
    }

    public Meeting saveMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    public Optional<Meeting> findMeetingById(Long id) {
        return meetingRepository.findMeetingById(id);
    }

    public Meeting MeetingOf(MeetingCreateRequest request, Authentication authentication) {
        User initiator = userService.findUserByUsername(authentication.getName()).orElseThrow(() -> new ResourceNotFoundException("User with given username doesn't exists"));
        User attendee = userService.findUserByUsername(request.getAttendeeUsername()).orElseThrow(() -> new ResourceNotFoundException("User with given username doesn't exists"));

        if (initiator.getAuthorities().contains(Role.CLIENT) && attendee.getAuthorities().contains(Role.CLIENT)) {
            throw new ResourceNotFoundException("Agency employee with given username doesn't exists");
        }

        Address address = new Address(request.getCity(), request.getZipCode(), request.getStreet());

        return new Meeting(initiator, attendee, request.getMeetingDateTime(), address);

    }

    public List<Meeting> getAllMeetings(Authentication authentication) {
        User user = userService.findUserByUsername(authentication.getName()).orElseThrow(() -> new ResourceNotFoundException("User with given username doesn't exists"));
        return meetingRepository.findAllByInitiatorOrAttendee(user, user);
    }

    public MeetingResponse mapToMeetingResponse(Meeting meeting) {
        Address address = meeting.getAddress();
        return new MeetingResponse(meeting.getId(), meeting.getAttendee().getUsername(), meeting.getMeetingDateTime(), address.getCity(), address.getZipCode(), address.getStreet());
    }

    public boolean isInitiator(Meeting meeting, Authentication authentication) {
        return meeting.getInitiator().getUsername().equals(authentication.getName());
    }


}
