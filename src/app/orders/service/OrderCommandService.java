package app.orders.service;

import app.orders.model.Order;
import app.system.utils.Data;

import java.util.List;

public interface OrderCommandService extends Data {

    void addOrder(Order order);

    void removeOrder(Order order);

}
