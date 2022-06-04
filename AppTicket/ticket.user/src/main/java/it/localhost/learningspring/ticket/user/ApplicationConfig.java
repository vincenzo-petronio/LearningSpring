package it.localhost.learningspring.ticket.user;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.localhost.learningspring.ticket.user.dto.UserDto;
import it.localhost.learningspring.ticket.user.model.User;

@Configuration
public class ApplicationConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.getConfiguration().setSkipNullEnabled(true);
		modelMapper.addMappings(userMapping);
		return modelMapper;
	}

	PropertyMap<User, UserDto> userMapping = new PropertyMap<User, UserDto>() {

		@Override
		protected void configure() {
			map().setName(source.getName());
		}
	};

}
