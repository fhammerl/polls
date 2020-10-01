package com.fhammerl.polls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fhammerl.polls.models.Poll;

public interface PollRepository extends JpaRepository<Poll, Long> {
}
