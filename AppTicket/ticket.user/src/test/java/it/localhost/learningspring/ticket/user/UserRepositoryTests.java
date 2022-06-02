package it.localhost.learningspring.ticket.user;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.localhost.learningspring.ticket.user.model.User;
import it.localhost.learningspring.ticket.user.model.UserRepository;

@SpringBootTest()
@TestMethodOrder(OrderAnnotation.class)
class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	@Order(1)
	void GetUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		assertThat(users.get(0).getName(), equalTo("admin")); // utente inserito dal bootstrap.sql
	}

}
