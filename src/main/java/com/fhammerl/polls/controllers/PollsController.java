package com.fhammerl.polls.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import com.fhammerl.polls.repositories.PollRepository;
import com.fhammerl.polls.models.Poll;
import com.fhammerl.polls.models.SearchQuery;

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


    // To Test: http://localhost:8080/api/v1/polls/createdBy?userId=4
    // To get a 500: http://localhost:8080/api/v1/polls/createdBy?userId=
    @GetMapping
    @RequestMapping("createdBy")
    public List<Poll> createdBy(int userId) {
        return pollRepository.findByCreatorId(userId);
    }

    // Test: http://localhost:8080/api/v1/polls/search
    // TODO: review post vs get for search. Sticking to post for now because of url encoding
    @PostMapping 
    @RequestMapping("search") // TODO: review ambiguous naming
    public List<Poll> search(@RequestBody SearchQuery query) {
        return pollRepository.findByTitle(query.getTitle());
    }    

    // Test: http://localhost:8080/api/v1/polls/listFrom?fromDate=2019-06-01 - all 3 polls
    // Test: http://localhost:8080/api/v1/polls/listFrom?fromDate=2020-05-15 - only 2
    // Test: http://localhost:8080/api/v1/polls/listFrom?fromDate=2020-06-15 - none
    @GetMapping
    @RequestMapping("listFrom")
    public List<Poll> listFrom(@DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate) {
        return pollRepository.listAfterDate(fromDate);
    }
}
