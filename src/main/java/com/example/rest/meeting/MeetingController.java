package com.example.rest.meeting;

import com.example.exception.ResourceNotFoundException;
import com.example.model.meeting.Meeting;
import com.example.rest.request.MeetingCreateRequest;
import com.example.rest.response.MeetingResponse;
import com.example.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${path.meeting}")
public class MeetingController {

    private MeetingService meetingService;

    @Autowired
    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("/{id}")
    public MeetingResponse getMeeting(@PathVariable Long id) {
        return meetingService.findMeetingById(id)
                .map(meetingService::mapToMeetingResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Meeting with given id doesn't exists"));
    }

    @GetMapping
    public List<MeetingResponse> getAllMeetings(Authentication authentication) {
        return meetingService.getAllMeetings(authentication)
                .stream()
                .map(meetingService::mapToMeetingResponse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void createMeeting(@RequestBody MeetingCreateRequest request, Authentication authentication) {
        Meeting meeting = meetingService.MeetingOf(request, authentication);
        meetingService.saveMeeting(meeting);
    }

    @DeleteMapping("/{id}")
    public void deleteMeeting(@PathVariable Long id) {
        // TODO
    }
}
