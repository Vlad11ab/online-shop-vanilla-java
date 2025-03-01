package app.Orders.Service;

import app.Orders.Model.Order;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {

    private List<Order> orders;

    public OrderService() {
        orders = new ArrayList<>();

        this.loadOrders();
    }

    private void loadOrders() {
        String filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app.Orders/Data/app.Orders.txt";

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






}
