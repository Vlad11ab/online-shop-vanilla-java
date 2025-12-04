package app.orderdetail.service;

import app.orderdetail.model.OrderDetail;
import app.system.utils.Data;

import java.util.List;

public interface OrderDetailQueryService  {

    void afisare();

    List<OrderDetail> findOrderDetailsByOrderId(int orderId);

}
