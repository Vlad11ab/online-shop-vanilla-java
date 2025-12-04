package app.orders.service;

import app.orders.exceptions.OrderAlreadyExistsException;
import app.orders.exceptions.OrderNotFoundException;
import app.orders.model.Order;
import app.orders.repository.OrderRepository;
import app.orders.repository.OrderRepositorySingleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class OrderCommandServiceImpl implements OrderCommandService {

    OrderRepository orderRepository;

    public OrderCommandServiceImpl () {
       orderRepository = OrderRepositorySingleton.getINSTANCE();
    }



    @Override
    public void addOrder(Order order) throws OrderAlreadyExistsException {

        Optional<Order> searchedOrder = orderRepository.findOrderById(order.getId());

        if(searchedOrder.isPresent()){
            throw new OrderAlreadyExistsException();
        } else {
            orderRepository.addOrder(order);
        }
    }

    @Override
    public void removeOrder(Order order) throws OrderNotFoundException {

        Optional<Order> searchedOrder = orderRepository.findOrderById(order.getId());

        if(searchedOrder.isEmpty()){
            throw new OrderNotFoundException();
        } else {
            orderRepository.removeOrder(order);
        }
    }






}
