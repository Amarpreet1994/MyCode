package com.psl.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.psl.bean.Dish;
import com.psl.bean.Location;
import com.psl.bean.Order;
import com.psl.util.DominozPizzaDelivery;
import com.psl.util.DominozPizzaDeliveryImpl;

public class Client {

	public static void main(String[] args) {
		List<Dish> list = new ArrayList<Dish>();
		Set<Location> set = new HashSet<Location>();
		DominozPizzaDelivery dm = new DominozPizzaDeliveryImpl();
		dm.populateData("dish.txt", "location.txt", list, set);
		System.out.println("----------dishs-----------");
		for(Dish d : list){
			System.out.println(d);
		}
		System.out.println(list.size());
		System.out.println("\n");
		System.out.println("------------locations-----------");
		for(Location l : set){
			System.out.println(l);
		}
		System.out.println(set.size());
		System.out.println("\n");
		dm.calculateLocationForDistance(list, set);
		System.out.println("----------dishs-----------");
		for(Dish d : list){
			System.out.println(d);
			System.out.println(d.getSet().size());
		}
		System.out.println(list.size());
		System.out.println("\n");
		List<Order> order = dm.calculateOrder("order.txt", list, set);
		for(Order o : order){
			System.out.println(o);
		}
		System.out.println(order.size());
		System.out.println("\n");
		dm.freeDelivery(order, list, set);
	}

}
