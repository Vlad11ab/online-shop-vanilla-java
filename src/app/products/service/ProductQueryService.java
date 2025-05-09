package app.products.service;

import app.products.model.Product;
import app.system.utils.Data;

import java.util.List;

public interface ProductQueryService extends Data {

    void showProducts();

    void showShoppingCart();

    void afisare();

    List<Product> getAllProductsById(int id);

    Product getProductById(int id);

    Product getProductByName(String name);

    boolean foundProduct(Product product);


}
