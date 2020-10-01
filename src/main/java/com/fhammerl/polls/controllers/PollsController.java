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

    @GetMapping
    public List<Poll> list() {
        return pollRepository.findAll();
    }
}
