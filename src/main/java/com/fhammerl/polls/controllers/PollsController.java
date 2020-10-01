package com.fhammerl.polls.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.fhammerl.polls.repositories.PollRepository;
import com.fhammerl.polls.models.Poll;

@RestController
@RequestMapping("api/v1/polls")
public class PollsController {
    @Autowired
    private PollRepository pollRepository;

    // Test: http://localhost:8080/api/v1/polls/list
    @GetMapping
    @RequestMapping("list")
    public List<Poll> list() {
        return pollRepository.findAll();
    }


    // Test: http://localhost:8080/api/v1/polls/createdBy?userId=4
    @GetMapping
    @RequestMapping("createdBy")
    public List<Poll> createdBy(int userId) {
        return pollRepository.findByCreatorId(userId);
    }
}
