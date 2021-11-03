package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {
	@Autowired
	private MenuItemService menuItemService;

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	public void setMenuItemService(MenuItemService menuItemService) {
		LOGGER.info("setMenuItemService START");
		this.menuItemService = menuItemService;
		LOGGER.info("setMenuItemService END");
	}

	@GetMapping("")
	public List<MenuItem> getAllMenuItems() {
		LOGGER.info("getAllMenuItems START");
		LOGGER.info("getAllMenuItems END");
		return this.menuItemService.getAllMenuItems();

	}

	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable int id) {
		LOGGER.info("getMenuItem START");
		LOGGER.info("getMenuItem END");
		return this.menuItemService.getMenuItem(id);
	}

	@PutMapping("")
	public void ModifyMenu(@RequestBody MenuItem menuItem) {
		LOGGER.info("ModifyMenu START");
		this.menuItemService.ModifyMenu(menuItem);
		LOGGER.info("ModifyMenu END");

	}

}
