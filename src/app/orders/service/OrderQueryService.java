package app.orders.service;

import app.orders.model.Order;
import app.system.utils.Data;

import java.util.List;

public interface OrderQueryService extends Data {

    void afisare();

    void showAllOrdersIds();

    List<Order> getOrdersByCustomerId(int customerId);

    public boolean checkOrderId(int orderId);

}
