package com.psl.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.psl.bean.Dish;
import com.psl.bean.Location;
import com.psl.util.DominozPizzaDeliveryImpl;

public class Client {

	private static final String dishFile = "dish.txt";
	private static final String locationFile = "location.txt";

	public static void main(String[] args) {

		List<Dish> dishes = new ArrayList<>();
		Set<Location> locations = new HashSet<>();

		DominozPizzaDeliveryImpl dominozPizzaDelivery = new DominozPizzaDeliveryImpl();

		dominozPizzaDelivery.populateData(dishFile,locationFile,dishes,locations);


	}

}
