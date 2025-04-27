package app.products.service;

public class ProductCommandServiceSingleton {

    private static class LazyHolder {
        private static final ProductCommandService instance = new ProductCommandServiceImpl();
    }

    private ProductCommandServiceSingleton() {

    }

    public static ProductCommandService getInstance() {
        return LazyHolder.instance;
    }

}
