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

public class OrderQueryServiceImpl implements OrderQueryService {

    private List<Order> orders;
    private String filename;

    public OrderQueryServiceImpl() {
        orders = new ArrayList<>();

        this.filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/orders/data/Orders.txt";
        this.loadData();
    }

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

    @Override
    public List<Order> getOrdersByCustomerId(int customerId) {
        this.loadData();

        List<Order> customersOrders = new ArrayList<>();
        for(Order order : orders) {
            if(order.getCustomerId() == customerId) {
                customersOrders.add(order);
            }
        }
        return customersOrders;
    }


    @Override
    public boolean checkOrderId(int orderId){
        this.loadData();

        for(Order order : orders) {
            if(order.getId() == orderId) {
                return true;
            }
        }
        return false;
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

    @Override
    public void afisare() {
        this.loadData();

        System.out.println(this);
    }

    @Override
    public void showAllOrdersIds(){
        this.loadData();

        for(Order order : orders) {
            System.out.println(order.getId());
        }
    }






}
