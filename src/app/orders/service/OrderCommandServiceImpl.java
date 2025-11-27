package app.orders.service;

import app.orders.model.Order;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class OrderCommandServiceImpl implements OrderCommandService {

    private List<Order> orders;
    private String filename;

    public OrderCommandServiceImpl() {
        orders = new ArrayList<>();

        this.filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/orders/data/Orders.txt";
//        this.loadData();
    }



    @Override
    public void addOrder(Order order) {
        order.setId(generateOrderId());
        orders.add(order);
    }

    @Override
    public void removeOrder(Order order) {
        orders.remove(order);
    }


    private int generateOrderId() {
//        this.loadData();

        Random rand = new Random();
        int orderID = rand.nextInt(10000)+1;
        while(getOrderById(orderID) != null) {
            orderID = rand.nextInt(10000)+1;
        }

        return orderID;
    }

    private Order getOrderById(int id) {
//        this.loadData();

        for(Order order : orders) {
            if(order.getId() == id) {
                return order;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        String text ="";
        for(int i = 0; i <orders.size()-1; i++){
            text += orders.get(i).toString() + "\n";
        }
        text += orders.get(orders.size()-1).toString();
        return text;
    }




}
