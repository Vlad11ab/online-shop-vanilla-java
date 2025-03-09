package app.OrderDetail.Service;

import app.OrderDetail.Model.OrderDetail;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderDetailService {

    private List<OrderDetail> orderdetails;

    public OrderDetailService() {
        orderdetails = new ArrayList<>();

        this.loadOrderDetails();
    }

    private void loadOrderDetails() {
        String filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/OrderDetail/Data/OrderDetails.txt";

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





}
