package app.orderdetail.service;

import app.orderdetail.model.OrderDetail;
import app.orderdetail.repository.OrderDetailRepository;
import app.orderdetail.repository.OrderDetailRepositorySingleton;
import app.orders.exceptions.OrderNotFoundException;

import java.util.List;
import java.util.Optional;

public class OrderDetailQueryServiceImpl implements OrderDetailQueryService {

    OrderDetailRepository orderDetailRepository;

    public OrderDetailQueryServiceImpl() {
        orderDetailRepository = OrderDetailRepositorySingleton.getINSTANCE();
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
