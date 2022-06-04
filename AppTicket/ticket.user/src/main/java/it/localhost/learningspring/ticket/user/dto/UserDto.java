package it.localhost.learningspring.ticket.user.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDto {

	private long id;
	
    private String name;

    private String surname;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;
    
    private Set<ContactDto> contacts = new HashSet<>();
    
    private Set<AddressDto> addresses = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<ContactDto> getContacts() {
		return contacts;
	}

	public void setContacts(Set<ContactDto> contacts) {
		this.contacts = contacts;
	}

	public Set<AddressDto> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<AddressDto> addresses) {
		this.addresses = addresses;
	}

}
