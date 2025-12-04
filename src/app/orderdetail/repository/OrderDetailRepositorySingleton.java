package app.orderdetail.repository;

import app.orders.repository.OrderRepository;
import app.orders.repository.OrderRepositoryImpl;
import app.orders.repository.OrderRepositorySingleton;

public class OrderDetailRepositorySingleton {

    private static class LazyHolder {

        private static final OrderDetailRepository INSTANCE = new OrderDetailRepositoryImpl();
    }

    private OrderDetailRepositorySingleton() {

    }

    public static OrderDetailRepository getINSTANCE() {
        return LazyHolder.INSTANCE;
    }
}
