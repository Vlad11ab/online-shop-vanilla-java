package app.orderdetail.service;

import app.orderdetail.exceptions.OrderNotFoundException;
import app.orderdetail.model.OrderDetail;
import app.orderdetail.repository.OrderDetailRepository;
import app.orderdetail.repository.OrderDetailRepositorySingleton;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class OrderDetailQueryServiceImpl implements OrderDetailQueryService {

    OrderDetailRepository orderDetailRepository;

    public OrderDetailQueryServiceImpl() {
        orderDetailRepository = OrderDetailRepositorySingleton.getINSTANCE();
    }

    @Override
    public String toString() {

        return orderDetailRepository.listOrderDetails().toString();
    }

    @Override
    public void afisare() {

        orderDetailRepository.listOrderDetails().forEach(System.out::println);
    }

    @Override
    public List<OrderDetail> findOrderDetailsByOrderId(int orderId) throws OrderNotFoundException {

        Optional<OrderDetail> searchedOrderDetail = orderDetailRepository.listOrderDetails().stream().filter(orderDetail -> orderDetail.getOrderId() == orderId).findAny();

        if(searchedOrderDetail.isEmpty()){
            throw new OrderNotFoundException();
        } else {
            return orderDetailRepository.findOrderDetailsByOrderId(orderId);
        }
    }


}
