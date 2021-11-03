package com.cognizant.truyum.dto;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDTO {
	private List<MenuItem> menuItemList;
	private double total;

	public CartDTO() {
		super();
	}

	public CartDTO(List<MenuItem> menuItemList, double total) {
		super();
		this.menuItemList = menuItemList;
		this.total = total;
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [menuItemList=" + menuItemList + ", total=" + total + "]";
	}

}
