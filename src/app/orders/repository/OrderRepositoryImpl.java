package app.orders.repository;

import app.orders.model.Order;
import app.products.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository{

    private List<Order> orders;
    String orderfilepath;

    public OrderRepositoryImpl() {
        orders = new ArrayList<>();

        this.orderfilepath = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/orders/data/Orders.txt";
//        this.loadData();
    }
}
