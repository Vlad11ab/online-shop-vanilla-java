package app.products.service;

public class ProductQueryServiceSingleton {

    private static class LazyHolder {
        private static final ProductQueryService instance = new ProductQueryServiceImpl();
    }

    private ProductQueryServiceSingleton() {

    }

    public static ProductQueryService getInstance() {
        return LazyHolder.instance;
    }
}
