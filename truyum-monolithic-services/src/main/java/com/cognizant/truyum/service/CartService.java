package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.truyum.dto.CartDTO;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.MenuItemRepository;
import com.cognizant.truyum.repository.UserRepository;

@Service
public class CartService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	MenuItemRepository menuItemRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(CartService.class);

	@Transactional
	public void addCartItem(int userId, int menuItemId) {
		LOGGER.info("addCartItem START");
		User user = this.userRepository.findById(userId).get();
		MenuItem menuItem = this.menuItemRepository.findById(menuItemId).get();
		if (menuItem != null) {
			List<MenuItem> menuItemList = user.getMenuItemList();
			menuItemList.add(menuItem);
			user.setMenuItemList(menuItemList);
			this.userRepository.save(user);
		}
		LOGGER.info("addCartItem END");
	}

	@Transactional
	public CartDTO getAllCartItems(int userId) throws CartEmptyException {
		LOGGER.info("getAllCartItems START");
		CartDTO cartDTO = new CartDTO();
		try {
			User user = this.userRepository.findById(userId).get();
			cartDTO.setMenuItemList(user.getMenuItemList());
			cartDTO.setTotal(userRepository.getCartTotalPrice(userId));
		} catch (Exception e) {
			throw new CartEmptyException();
		}
		LOGGER.info("getAllCartItems END");
		return cartDTO;

	}

	@Transactional
	public void removeCartItem(int userId, int menuItemId) {
		LOGGER.info("removeCartItem START");
		User user = this.userRepository.findById(userId).get();
		MenuItem menuItem = this.menuItemRepository.findById(menuItemId).get();
		if (menuItem != null) {
			List<MenuItem> menuItemList = user.getMenuItemList();
			menuItemList.remove(menuItem);
			user.setMenuItemList(menuItemList);
			this.userRepository.save(user);
		}
		LOGGER.info("removeCartItem END");
	}

}
