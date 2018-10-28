package com.psl.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.psl.bean.Dish;
import com.psl.bean.Location;
import com.psl.bean.Order;


public class DominozPizzaDeliveryImpl implements DominozPizzaDelivery {

	@Override
	public void populateData(String dishFile, String locationFile,
			List<Dish> dishs, Set<Location> locations) {
		Scanner scan = null;
		try {
			scan = new Scanner(new File(dishFile));
			while(scan.hasNext()){
				String t[] = scan.nextLine().split(",");
				int dishId = Integer.parseInt(t[0].trim());
				String dishName = t[1].trim();
				double cost = Double.parseDouble(t[2].trim());
				double timeToCook = Double.parseDouble(t[3].trim());
				dishs.add(new Dish(dishId, dishName, cost, timeToCook, new HashSet<Location>()));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally{scan.close();}
	
		try {
			scan = new Scanner(new File(locationFile));
			while(scan.hasNext()){
				String t[] = scan.nextLine().split(",");
				int locationCode = Integer.parseInt(t[0].trim());
				int locationDistance = Integer.parseInt(t[1].trim());
				double locationTime = Double.parseDouble(t[2].trim());
				locations.add(new Location(locationCode, locationDistance, locationTime));
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally{scan.close();}
		
		
	}

	@Override
	public void calculateLocationForDistance(List<Dish> dishs,
			Set<Location> locations) {
		for(Dish d : dishs){
			for(Location l : locations){
				if(d.getTimeToCook() + l.getLocationTime() <= 30){
					d.getSet().add(l);
				}
			}
		}
	}

	@Override
	public List<Order> calculateOrder(String orderFile, List<Dish> dishs,
			Set<Location> locations) {
		Scanner scan = null;
	List<Order> list = new ArrayList<Order>();
	try {
		scan = new Scanner(new File(orderFile));
		while(scan.hasNext()){
			String t[] = scan.nextLine().split(",");
			int dishId = Integer.parseInt(t[0].trim());
			int locationCode = Integer.parseInt(t[1].trim());
			for(Dish d : dishs){
				for(Location l : locations){
					if(d.getDishId() == dishId && l.getLocationCode() == locationCode){
					if(d.getTimeToCook() + l.getLocationTime() <= 30){
						double cost = d.getCost() + l.getLocationDistance() * 1;
						list.add(new Order(dishId, locationCode, cost));
					}
					}
				}
			}
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{scan.close();}
	return list;
	
	}

	@Override
	public void freeDelivery(List<Order> orders, List<Dish> dishs,
			Set<Location> locations) {
		for(Order o : orders){
			for(Dish d : dishs){
					for(Location l : locations){
						if(o.getDishId() == d.getDishId() && o.getLocationCode() == l.getLocationCode()){
							if(d.getCost() >200 && l.getLocationDistance() <=10){
								o.setTotalCost(d.getCost());
								System.out.println(o);
							}
						}
					}
			}
		}
	}


	
}
