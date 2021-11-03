package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;
import com.cognizant.truyum.security.AppUserDetailsService;

@Service
public class MenuItemService {

	@Autowired
	private MenuItemRepository menuItemRepository;

	@Autowired
	private AppUserDetailsService appUserDetailsService;

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemService.class);

	@Transactional
	public List<MenuItem> getAllMenuItems() {
		LOGGER.info("getAllMenuItems START");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		LOGGER.debug("The user is   ---------" + user);
		if (user.equals("anonymousUser")) {
			LOGGER.info("user is anonymous");
			return this.getMenuItemListCustomer();
		} else {
			UserDetails userDetails = appUserDetailsService.loadUserByUsername(user);
			String role = userDetails.getAuthorities().toArray()[0].toString();
			LOGGER.debug("the role is" + role);

			if (role.equals("ADMIN")) {
				LOGGER.debug("the role is " + role);
				return this.getMenuItemListAdmin();
			} else {
				LOGGER.debug("the role is customer " + role);
				return this.getMenuItemListCustomer();
			}
		}
	}

	@Transactional
	public MenuItem getMenuItem(int menuItemId) {
		LOGGER.info("getMenuItem START");
		LOGGER.info("getMenuItem END");
		return this.menuItemRepository.findById(menuItemId).get();
	}

	@Transactional
	public void ModifyMenu(MenuItem menuItem) {
		LOGGER.info("ModifyMenu START");
		this.menuItemRepository.save(menuItem);
		LOGGER.info("ModifyMenu END");
	}

	@Transactional
	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("getMenuItemListCustomer START");
		LOGGER.info("getMenuItemListCustomer END");
		return this.menuItemRepository.getMenuItemListCustomer();
	}

	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {
		LOGGER.info("getMenuItemListAdmin START");
		LOGGER.info("getMenuItemListCustomer END");
		return this.menuItemRepository.findAll();
	}

}
