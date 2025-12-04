package app.products.service;

import app.products.exceptions.ProductNotFoundException;
import app.products.model.Product;
import app.system.utils.Data;

import java.util.List;
import java.util.Optional;

public interface ProductQueryService extends Data {

    void showProducts();

    void afisare();

    Product findProductByName(String name) throws ProductNotFoundException;

    boolean foundProduct(Product product);
}
