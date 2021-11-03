package com.cognizant.truyum.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.dto.CartDTO;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	@Autowired
	CartService cartService;
	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@PostMapping("/{userId}/{menuItemId}")
	void addCartItem(@PathVariable int userId, @PathVariable int menuItemId) {
		LOGGER.info("addCartItem START");
		this.cartService.addCartItem(userId, menuItemId);
		LOGGER.info("addCartItem END");
	}

	@GetMapping("/{userId}")
	CartDTO getAllCartItems(@PathVariable int userId) throws CartEmptyException {
		LOGGER.info("getALLCARTITEMS START");
		LOGGER.info("getALLCARTITEMS END");
		return this.cartService.getAllCartItems(userId);
	}

	@DeleteMapping("/{userId}/{menuItemId}")
	void removeCartItem(@PathVariable int userId, @PathVariable int menuItemId) {
		LOGGER.info("removeCartItem START");
		this.cartService.removeCartItem(userId, menuItemId);
		LOGGER.info("removeCartItem END");
	}

}
