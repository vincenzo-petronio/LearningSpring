package it.localhost.learningspring.ticket.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.localhost.learningspring.ticket.user.model.User;
import it.localhost.learningspring.ticket.user.model.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> GetListUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> GetUser(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User SaveUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setBirthday(userDTO.getBirthday());

        return userRepository.save(user);
    }

}
