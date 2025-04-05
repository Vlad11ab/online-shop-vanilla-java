package app.Orders.Service;

import app.OrderDetail.Model.OrderDetail;
import app.Orders.Model.Order;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.random;

public class OrderService {

    private List<Order> orders;
    private String filename;

    public OrderService() {
        orders = new ArrayList<>();

        this.filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/Orders/Data/Orders.txt";
        this.loadOrders();
    }

    private void loadOrders() {

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

        List<Order> customersOrders = new ArrayList<>();
        for(Order order : orders) {
            if(order.getCustomerId() == customerId) {
                customersOrders.add(order);
            }
        }
        return customersOrders;
     }

     public void showAllOrdersIds(){
        for(Order order : orders) {
            System.out.println(order.getId());
        }
     }


    public  void saveAll(){

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


    @Override
    public String toString() {
        String text="";
        for(int i = 0; i < orders.size()-1; i++){
            text += orders.get(i).toString() + "\n";
        }
        text += orders.get(orders.size()-1).toString();
        return text;
    }


}
