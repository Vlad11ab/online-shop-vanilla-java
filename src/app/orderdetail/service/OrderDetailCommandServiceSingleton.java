package app.orderdetail.service;

public class OrderDetailCommandServiceSingleton {

    public static class LazyHolder {

        private static final OrderDetailCommandService instance = new OrderDetailCommandServiceImpl();
    }


    private OrderDetailCommandServiceSingleton() {

    }

    public static OrderDetailCommandService getInstance() {
        return LazyHolder.instance;
    }

}

