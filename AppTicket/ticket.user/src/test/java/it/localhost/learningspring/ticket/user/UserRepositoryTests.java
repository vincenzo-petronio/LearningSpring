package it.localhost.learningspring.ticket.user;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.localhost.learningspring.ticket.user.model.Contact;
import it.localhost.learningspring.ticket.user.model.ContactType;
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

	@Test
	@Order(2)
	void FindByNameLike() {
		// Query Methods di JPA usando le keyword
		List<User> users = userRepository.findByNameLike("adm%"); 
		assertThat(users.size(), equalTo(1));
	}
	
	@Test
	@Order(3)
	void AddContacts() {
		
		List<User> users = userRepository.findByNameLike("admin"); 
		User userAdmin = users.get(0);
		
		Contact c1 = new Contact();
		c1.setType(ContactType.EMAIL);
		c1.setValue("admin@localhost.it");
		c1.setUser(userAdmin);
		
		Contact c2 = new Contact();
		c2.setType(ContactType.MOBILE);
		c2.setValue("0009999999");
		c2.setUser(userAdmin);
		
		Set<Contact> contacts = new HashSet<>();
		contacts.add(c1);
		contacts.add(c2);
		
		userAdmin.setContacts(contacts);
		
		userRepository.save(userAdmin);
	}
	
	@Test
	@Order(4)
	void GetContacts() {
		List<User> users = userRepository.findByNameLike("admin"); 
		User userAdmin = users.get(0);
		assertThat(userAdmin.getContacts().size(), equalTo(2));
	}
}
