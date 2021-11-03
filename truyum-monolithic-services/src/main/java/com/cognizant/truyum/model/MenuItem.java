package com.cognizant.truyum.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "menu_item")
public class MenuItem {
	@Id
	@Column(name = "me_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "me_name")
	String name;

	@Column(name = "me_price")
	double price;

	@Column(name = "me_active")
	boolean active;

	@Column(name = "me_date_of_launch")
	Date dateOfLaunch;

	@Column(name = "me_category")
	String category;

	@Column(name = "me_free_delivery")
	boolean freeDelivery;

	@Column(name = "me_url")
	String url;
	

	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenuItem(String name, double price, boolean active, Date dateOfLaunch, String category, boolean freeDelivery,
			String url) {
		super();
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
		this.url = url;

	}

	public MenuItem(int id, String name, double price, boolean active, Date dateOfLaunch, String category,
			boolean freeDelivery, String url) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
		this.url = url;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}