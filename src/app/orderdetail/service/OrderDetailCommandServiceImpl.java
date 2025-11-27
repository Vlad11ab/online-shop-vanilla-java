package app.orderdetail.service;

import app.orderdetail.model.OrderDetail;
import app.orders.model.Order;

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

        this.filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/orderdetail/data/OrderDetails.txt";
//        this.loadData();
    }

    public void loadData() {
        orderdetails.clear();

        File file = new File(filename);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                OrderDetail orderDetail = new OrderDetail(line);
                orderdetails.add(orderDetail);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetail.setId(generateOrderDetailId());

        this.orderdetails.add(orderDetail);
        this.saveData();
    }

    private int generateOrderDetailId() {
        this.loadData();

        Random rand = new Random();
        int orderDetailId = rand.nextInt(10000)+1;
        while(getOrderDetailById(orderDetailId) != null) {
            orderDetailId = rand.nextInt(10000)+1;
        }

        return orderDetailId;
    }

    private OrderDetail getOrderDetailById(int id) {
        this.loadData();

        for(OrderDetail orderDetail : orderdetails) {
            if(orderDetail.getId() == id) {
                return orderDetail;
            }
        }

        return null;
    }

    @Override
    public void removeOrderDetail(OrderDetail orderDetail) {
        this.orderdetails.remove(orderDetail);
    }



    public int generateOrderId() {
        Random rand = new Random();
        int orderID = rand.nextInt(10000) + 1;
        while (getOrderDetailsByOrderId(orderID) != null) {
            orderID = rand.nextInt(10000) + 1;
        }

        return orderID;
    }

    public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {

        for( OrderDetail orderDetail : orderdetails ) {
            if(orderDetail.getOrderId() == orderId) {
                return orderdetails;
            }
        }return null;
    }

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

    @Override
    public String toString() {
        String text="";
        for(int i = 0; i < orderdetails.size()-1; i++){
            text += orderdetails.get(i).toString() + "\n";
        }
        text += orderdetails.get(orderdetails.size()-1).toString();
        return text;
    }


}
