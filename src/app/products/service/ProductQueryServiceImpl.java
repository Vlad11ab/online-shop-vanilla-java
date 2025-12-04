package app.products.service;

import app.products.exceptions.ProductNotFoundException;
import app.products.model.Product;
import app.products.repository.ProductRepository;
import app.products.repository.ProductRepositorySingleton;
import app.system.cart.CartItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductQueryServiceImpl implements ProductQueryService {

    ProductRepository productRepository;

    public ProductQueryServiceImpl() {
        productRepository = ProductRepositorySingleton.getINSTANCE();

    }

    @Override
    public void showProducts() {

        productRepository.listProducts().forEach(System.out::println);
    }

    @Override
    public void afisare(){

        productRepository.listProducts().forEach(System.out::println);
    }

    @Override
    public Product findProductByName(String name) throws ProductNotFoundException {
        Optional<Product> product= productRepository.findProductByName(name);

        if(product.isEmpty()){
            throw new ProductNotFoundException();
        }

        return product.get();

    }

    @Override
    public boolean foundProduct(Product product) {
        if(!productRepository.foundProduct(product)){
            return false;
        } else {

            return true;
        }
    }

    @Override
    public String toString(){

        return productRepository.listProducts().toString();
    }



}
