package app.orderdetail.service;

import app.orderdetail.model.OrderDetail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class OrderDetailCommandServiceImpl implements OrderDetailCommandService {

    private List<OrderDetail> orderdetails;
    private String filename;

    public OrderDetailCommandServiceImpl() {
        orderdetails = new ArrayList<>();

        this.filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/OrderDetail/Data/OrderDetails.txt";
        this.loadData();
    }

    @Override
    public void loadData() {

        File file = new File(filename);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                OrderDetail orderDetail = new OrderDetail(line);
                orderdetails.add(orderDetail);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addOrderDetail(OrderDetail orderDetail) {

        this.orderdetails.add(orderDetail);
    }

    @Override
    public void removeOrderDetail(OrderDetail orderDetail) {
        this.orderdetails.remove(orderDetail);
    }

    @Override
    public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {

        for (OrderDetail orderdetail : orderdetails) {
            if (orderdetail.getOrderId() == orderId) {
                return orderdetails;
            }
        }

        return null;
    }

    @Override
    public int generateOrderId() {
        Random rand = new Random();
        int orderID = rand.nextInt(10000) + 1;
        while (getOrderDetailsByOrderId(orderID) != null) {
            orderID = rand.nextInt(10000) + 1;
        }

        return orderID;
    }

    @Override
    public void saveData() {

        File file = new File(filename);
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(this);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
