package app.orders.service;

import app.orders.exceptions.CustomerNotFoundException;
import app.orders.model.Order;
import app.orders.repository.OrderRepository;
import app.orders.repository.OrderRepositorySingleton;

import java.util.*;

public class OrderQueryServiceImpl implements OrderQueryService {

    OrderRepository orderRepository;

    public OrderQueryServiceImpl() {
        orderRepository = OrderRepositorySingleton.getINSTANCE();
    }


    @Override
    public boolean checkOrderId(int orderId){
        return orderRepository.listOrders().stream().anyMatch(order -> order.getId() == orderId);

    }

    @Override
    public List<Order> findOrdersByCustomerId(int customerId) throws CustomerNotFoundException {

        Optional<Order> optionalOrder = orderRepository.findOrderById(customerId);

        if(optionalOrder.isEmpty()){
            throw new CustomerNotFoundException();
        } else {
            return findOrdersByCustomerId(customerId);
        }


    }

    @Override
    public void afisare() {

        orderRepository.listOrders().forEach(System.out::println);
    }

    @Override
    public void showAllOrdersIds(){

        orderRepository.listOrders().forEach(order -> System.out.println(order.getId()));
    }






}
