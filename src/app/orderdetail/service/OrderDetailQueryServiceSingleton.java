package app.orderdetail.service;

public class OrderDetailQueryServiceSingleton {

    private static class LazyHolder {

        private static final OrderDetailQueryService instance = new OrderDetailQueryServiceImpl();
    }


    private OrderDetailQueryServiceSingleton() {

    }

    public static OrderDetailQueryService getInstance() {
        return LazyHolder.instance;
    }

}
