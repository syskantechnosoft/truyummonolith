package com.cognizant.truyum.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.UserAlreadyExistsException;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.UserRepository;
import com.cognizant.truyum.security.AppUserDetailsService;

@RestController
@RequestMapping("/users")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	AppUserDetailsService appUserDetailsService;

	public static List<UserDetails> userDetailsList = new ArrayList<>();

	public UserController() {
		super();
	}

	@PostMapping("")
	void signup(@RequestBody @Valid User user) throws UserAlreadyExistsException {
		LOGGER.info("signUp START");
		appUserDetailsService.signUp(user);
		LOGGER.info("signUp END");
	}
}
