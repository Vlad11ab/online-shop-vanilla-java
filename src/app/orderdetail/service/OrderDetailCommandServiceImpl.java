package app.orderdetail.service;

import app.orderdetail.exceptions.OrderDetailAlreadyExistsException;
import app.orderdetail.exceptions.OrderDetailNotFoundException;
import app.orderdetail.model.OrderDetail;
import app.orderdetail.repository.OrderDetailRepository;
import app.orderdetail.repository.OrderDetailRepositorySingleton;
import app.orders.model.Order;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class OrderDetailCommandServiceImpl implements OrderDetailCommandService {

    OrderDetailRepository orderDetailRepository;

    public OrderDetailCommandServiceImpl() {
        orderDetailRepository = OrderDetailRepositorySingleton.getINSTANCE();
    }

    @Override
    public void addOrderDetail(OrderDetail orderDetail) throws OrderDetailAlreadyExistsException {

        Optional<OrderDetail> searchedOrderDetail = orderDetailRepository.findOrderDetailById(orderDetail.getId());

        if(searchedOrderDetail.isPresent()){
            throw new OrderDetailAlreadyExistsException();
        } else {
            orderDetailRepository.addOrderDetail(orderDetail);
        }
    }


    @Override
    public void removeOrderDetail(OrderDetail orderDetail) throws OrderDetailNotFoundException {

        Optional<OrderDetail> searchedOrderDetail = orderDetailRepository.findOrderDetailById(orderDetail.getId());

        if(searchedOrderDetail.isEmpty()){
            throw new OrderDetailNotFoundException();
        } else {
            orderDetailRepository.listOrderDetails().remove(orderDetail);
        }
    }





}
