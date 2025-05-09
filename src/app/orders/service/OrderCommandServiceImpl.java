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
        this.loadData();
    }

    @Override
    public void loadData() {

        File file = new File(filename);

        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Order order = new Order(line);
                orders.add(order);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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

    @Override
    public  void saveData(){

        File file = new File(filename);
        try{
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(this);
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private int generateOrderId() {
        this.loadData();

        Random rand = new Random();
        int orderID = rand.nextInt(10000)+1;
        while(getOrderById(orderID) != null) {
            orderID = rand.nextInt(10000)+1;
        }

        return orderID;
    }

    private Order getOrderById(int id) {
        this.loadData();

        for(Order order : orders) {
            if(order.getId() == id) {
                return order;
            }
        }

        return null;
    }





}
