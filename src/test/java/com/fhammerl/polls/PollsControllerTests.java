package com.fhammerl.polls;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.fhammerl.polls.models.Poll;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.fhammerl.polls.controllers.PollsController;
/*
	These tests are all dpeendent on the DB being set up properly
	They are at best smoke test
*/

@SpringBootTest
@AutoConfigureMockMvc
class PollsControllerTests {

	@Autowired
	private PollsController pollsController;

	@Test
	void listAllWorks() throws Exception {
		List<Poll> polls = pollsController.list();
		assertEquals(polls.toArray().length, 3, "Unexpected number of polls found!");
	}

	@Test
	void listCreatedByUserWorks() throws Exception {
		List<Poll> polls = pollsController.createdBy(4);
		assertEquals(polls.toArray().length, 2, "Unexpected number of polls found for user 4!");
	}
}