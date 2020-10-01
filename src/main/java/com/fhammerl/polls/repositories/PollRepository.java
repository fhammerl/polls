package com.fhammerl.polls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

import com.fhammerl.polls.models.Poll;

public interface PollRepository extends JpaRepository<Poll, Integer> {
    @Query("SELECT p FROM poll p where p.createdByUserId = :id") 
    List<Poll> findByCreatorId(@Param("id") Integer userId);

    @Query("SELECT p FROM poll p where p.title = :title") 
    List<Poll> findByTitle(@Param("title") String title);

    @Query("SELECT p FROM poll p where p.initiated > :fromDate") 
    List<Poll> listAfterDate(@Param("fromDate") Date fromDate);
}
