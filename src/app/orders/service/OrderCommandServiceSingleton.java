package app.orders.service;

public class OrderCommandServiceSingleton {

    private static class LazyHolder {

        private static final OrderCommandService instance = new OrderCommandServiceImpl();
    }

    private OrderCommandServiceSingleton() {

    }

    public static OrderCommandService getInstance() {
        return LazyHolder.instance;
    }

}
