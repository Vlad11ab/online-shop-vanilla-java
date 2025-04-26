package app.OrderDetail.Service;

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

public class OrderDetailService {

    private static OrderDetailService instance;

    private List<OrderDetail> orderdetails;
    private String filename;

    private OrderDetailService() {
        orderdetails = new ArrayList<>();

        this.filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/OrderDetail/Data/OrderDetails.txt";
        this.loadOrderDetails();
    }

    public static OrderDetailService getInstance(){
        if(instance == null){
            instance = new OrderDetailService();
        }
        return instance;
    }

    private void loadOrderDetails() {

        File file = new File(filename);

        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                OrderDetail orderDetail = new OrderDetail(line);
                orderdetails.add(orderDetail);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addOrderDetail(OrderDetail orderDetail) {

        this.orderdetails.add(orderDetail);
    }

    public void removeOrderDetail(OrderDetail orderDetail) {
        this.orderdetails.remove(orderDetail);
    }


    public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {

        for(OrderDetail orderdetail : orderdetails) {
            if(orderdetail.getOrderId() == orderId) {
                return orderdetails;
            }
        }

        return null;
    }

    public int generateOrderID() {
        Random rand = new Random();
        int orderID = rand.nextInt(10000)+1;
        while(getOrderDetailsByOrderId(orderID) != null) {
            orderID = rand.nextInt(10000)+1;
        }

        return orderID;
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




}
