package app.orderdetail.service;

import app.orderdetail.model.OrderDetail;
import app.system.utils.Data;

import java.util.List;

public interface OrderDetailCommandService extends Data {

    void addOrderDetail(OrderDetail orderDetail);

    void removeOrderDetail(OrderDetail orderDetail);




}
