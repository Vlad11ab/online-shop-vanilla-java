package app.orders.service;

public class OrderQueryServiceSingleton {

    private static class LazyHolder {
        private static final OrderQueryService instance = new OrderQueryServiceImpl();
    }

    private OrderQueryServiceSingleton() {

    }

    public static OrderQueryService getInstance() {
        return LazyHolder.instance;
    }


}
