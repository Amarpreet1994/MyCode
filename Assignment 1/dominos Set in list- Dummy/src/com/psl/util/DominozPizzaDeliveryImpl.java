package com.psl.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Set;

import com.psl.bean.Dish;
import com.psl.bean.Location;
import com.psl.bean.Order;


public class DominozPizzaDeliveryImpl implements DominozPizzaDelivery {


    @Override
    public void populateData(String dishFile, String locationFile, List<Dish> dishs, Set<Location> locations) {
        File dishFileObject = new File(dishFile);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(dishFileObject));
            String dishLine;
            while ((dishLine = br.readLine()) != null){
                Dish dish = new Dish();
                String[] splitedLine = dishLine.split(",");
                dish.setDishId(Integer.valueOf(splitedLine[0]));
                dish.setDishName(splitedLine[1]);
                dish.setCost(Double.valueOf(splitedLine[2]));
                dish.setTimeToCook(Double.valueOf(splitedLine[3]));

                dishs.add(dish);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        File locationFileObject = new File(locationFile);

        BufferedReader br1 = null;
        try {
            br1 = new BufferedReader(new FileReader(locationFileObject));
            String locationLine;
            while ((locationLine = br1.readLine()) != null){
                Location location = new Location();
                String[] splitedLine = locationLine.split(",");

                location.setLocationCode(Integer.valueOf(splitedLine[0]));
                location.setLocationDistance(Integer.valueOf(splitedLine[1]));
                location.setLocationTime(Double.valueOf(splitedLine[2]));

                locations.add(location);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void calculateLocationForDistance(List<Dish> dishs, Set<Location> locations) {

    }

    @Override
    public List<Order> calculateOrder(String orderFile, List<Dish> dishs, Set<Location> locations) {
        return null;
    }

    @Override
    public void freeDelivery(List<Order> orders, List<Dish> dishs, Set<Location> locations) {

    }
}
