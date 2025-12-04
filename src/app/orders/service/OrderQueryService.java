package app.orders.service;

import app.orders.model.Order;
import app.system.utils.Data;

import java.util.List;
import java.util.Optional;

public interface OrderQueryService extends Data {

    void afisare();

    void showAllOrdersIds();

    boolean checkOrderId(int orderId);

    List<Order> findOrdersByCustomerId(int customerId);

}
