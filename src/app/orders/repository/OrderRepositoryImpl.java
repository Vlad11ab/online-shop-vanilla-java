package app.orders.repository;

import app.orders.model.Order;

import java.io.*;
import java.util.*;

public class OrderRepositoryImpl implements OrderRepository{

    private List<Order> orders;
    String filename;

    public OrderRepositoryImpl() {
        orders = new ArrayList<>();

        this.filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/orders/data/Orders.txt";
        this.loadData();
    }

    public void loadData() {
        File file = new File(filename);

        try(Scanner scanner = new Scanner(file)){
            String line = scanner.nextLine();
            Order order = new Order(line);
            orders.add(order);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveData() {
        File file = new File(filename);

        try{
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(this);
            printWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Order> findOrderById(int orderId) {

        return orders.stream().filter(order -> order.getId() == orderId).findAny();
    }

    @Override
    public List<Order> listOrders() {

        return orders.stream().toList();
    }

    @Override
    public Optional<Order> findOrdersByCustomerId(int customerId) {

        Optional<Order> customerOrders = orders.stream().filter(order -> order.getCustomerId() == customerId).findAny();

        return customerOrders;
    }

    @Override
    public void addOrder(Order order) {
        order.setId(generateUniqueOrderId());
        orders.add(order);
        this.saveData();
    }

    @Override
    public void removeOrder(Order order) {
        orders.remove(order);
        this.saveData();
    }

    private int generateUniqueOrderId() {

        Random rand = new Random();
        int orderID = rand.nextInt(10000)+1;
        while(findOrderById(orderID).isPresent()) {
            orderID = rand.nextInt(10000)+1;
        }

        return orderID;
    }


}
