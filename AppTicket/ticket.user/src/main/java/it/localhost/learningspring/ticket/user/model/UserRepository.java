package it.localhost.learningspring.ticket.user.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByNameLike(String name);
}
