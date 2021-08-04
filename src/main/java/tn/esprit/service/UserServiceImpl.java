package tn.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRep;

	public UserRepository getUserRep() {
		return userRep;
	}

	public void setUserRep(UserRepository userRep) {
		this.userRep = userRep;
	}
	
}
