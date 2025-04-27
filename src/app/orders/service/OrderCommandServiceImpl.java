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

        this.filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/Orders/Data/Orders.txt";
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
        orders.add(order);
    }

    @Override
    public void removeOrder(Order order) {
        orders.remove(order);
    }

    @Override
    public Order getOrderById(int id) {


        for(Order order : orders) {
            if(order.getId() == id) {
                return order;
            }
        }

        return null;
    }

    @Override
    public boolean checkOrderId(int orderId){
        for(Order order : orders) {
            if(order.getId() == orderId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int generateOrderId() {
        Random rand = new Random();
        int orderID = rand.nextInt(10000)+1;
        while(getOrderById(orderID) != null) {
            orderID = rand.nextInt(10000)+1;
        }

        return orderID;
    }

    @Override
    public List<Order> getOrdersByCustomerId(int customerId) {

        List<Order> customersOrders = new ArrayList<>();
        for(Order order : orders) {
            if(order.getCustomerId() == customerId) {
                customersOrders.add(order);
            }
        }
        return customersOrders;
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





}
