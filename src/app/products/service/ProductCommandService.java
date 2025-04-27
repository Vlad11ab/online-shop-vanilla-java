package app.products.service;

import app.products.model.Product;
import app.system.utils.Data;

import java.util.List;

public interface ProductCommandService extends Data {

    Product getProductById(int id);

    Product getProductByName(String name);

    boolean foundProduct(Product product);

    List<Product> getAllProductsById(int id);
}
