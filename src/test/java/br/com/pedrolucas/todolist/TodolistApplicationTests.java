package br.com.pedrolucas.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.pedrolucas.todolist.entity.Todo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TodolistApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSuccess() {
		var todo = new Todo("Test Todo","desc todo test", 1, false);

		webTestClient.post()
		.uri("/todos").
		bodyValue(todo).
		exchange().
		expectStatus().
		isOk().
		expectBody().
		jsonPath("$").isArray().
		jsonPath("$.length()").isEqualTo(1).
		jsonPath("$[0].title").isEqualTo(todo.getTitle()).
		jsonPath("$[0].description").isEqualTo(todo.getDescription()).
		jsonPath("$[0].priority").isEqualTo(todo.getPriority()).
		jsonPath("$[0].realized").isEqualTo(todo.isRealized())
		;
	}

	@Test
	void testCreateTodoFailure() {
		webTestClient.post()
		.uri("/todos").
		bodyValue(
			new Todo("","", 0, false)).
		exchange().
		expectStatus().
		isBadRequest();
	}
}
