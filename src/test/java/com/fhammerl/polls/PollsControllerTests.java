package com.fhammerl.polls;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import com.fhammerl.polls.models.Poll;
import com.fhammerl.polls.models.SearchQuery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.fhammerl.polls.controllers.PollsController;
/*
	All the setup for these tests is in insert_rows.sql
	They are at best smoke tests
*/

@SpringBootTest
@AutoConfigureMockMvc
class PollsControllerTests {

	@Autowired
	private PollsController pollsController;

	@Test
	void canListAll() throws Exception {
		List<Poll> polls = pollsController.list();
		assertEquals(polls.toArray().length, 3, "Unexpected number of polls found!");
	}

	@Test
	void canListCreatedByUser() throws Exception {
		List<Poll> polls = pollsController.createdBy(4);
		assertEquals(polls.toArray().length, 2, "Unexpected number of polls found for user 4!");
	}

	@Test
	void canGetByTitle() throws Exception {
		SearchQuery query = new SearchQuery();
		query.setTitle("谁是最坏蛋奇迹超级英雄?");
		List<Poll> polls = pollsController.search(query);
		assertEquals(polls.toArray().length, 1, "Unexpected number of polls found for title '谁是最坏蛋奇迹超级英雄?'!");
	}

	@Test
	void canListFromDate() throws Exception {
		List<Poll> polls = pollsController.listFrom(new Date(1590969600)); // 2020-06-01T00:00:00+00:00
		assertEquals(polls.toArray().length, 2, "Unexpected number of polls found for user 4!");
	}
}