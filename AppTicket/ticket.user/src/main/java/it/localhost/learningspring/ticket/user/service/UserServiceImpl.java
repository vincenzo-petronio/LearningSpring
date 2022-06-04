package it.localhost.learningspring.ticket.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.localhost.learningspring.ticket.user.dto.UserDto;
import it.localhost.learningspring.ticket.user.model.User;
import it.localhost.learningspring.ticket.user.model.UserRepository;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> GetListUsers() {
         return ((List<User>) userRepository.findAll())
         	.stream()
         	.map(u -> modelMapper.map(u, UserDto.class))
         	.collect(Collectors.toUnmodifiableList())
         	;
    }

    @Override
    public Optional<UserDto> GetUser(long id) {
        return (userRepository.findById(id))
//        		.stream()
        		.map(u -> modelMapper.map(u , UserDto.class))
        		;
    }

    @Override
    @Transactional
    public User SaveUser(UserDto userDto) {
    	User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setBirthday(userDto.getBirthday());

        return userRepository.save(user);
    }

}
