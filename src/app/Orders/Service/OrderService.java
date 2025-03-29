package app.Orders.Service;

import app.OrderDetail.Model.OrderDetail;
import app.Orders.Model.Order;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.random;

public class OrderService {

    private List<Order> orders;

    public OrderService() {
        orders = new ArrayList<>();

        this.loadOrders();
    }

    private void loadOrders() {
        String filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/OrderDetail/Data/OrderDetails.txt";

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

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }


    public  Order getOrderById(int id) {


        for(Order order : orders) {
            if(order.getId() == id) {
                return order;
            }
        }

        return null;
    }

    public boolean checkOrderId(int orderId){
        for(Order order : orders) {
            if(order.getId() == orderId) {
                return true;
            }
        }
        return false;
    }


    public int generateOrderID() {
        Random rand = new Random();
        int orderID = rand.nextInt(10000)+1;
        while(getOrderById(orderID) != null) {
            orderID = rand.nextInt(10000)+1;
        }

        return orderID;
    }


    //todo:getAllOrdersByCustomerId

     public List<Order> getOrdersByCustomerId(int customerId) {

        List<Order> orders = new ArrayList<>();
        for(Order order : orders) {
            if(order.getCustomerId() == customerId) {
                orders.add(order);
            }
        }
        return orders;
     }

     public void showAllOrdersIds(){
        for(Order order : orders) {
            System.out.println(order.getId());
        }
     }


}
