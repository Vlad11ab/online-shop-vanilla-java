package app.products.service;

import app.products.model.Product;
import app.products.repository.ProductRepository;
import app.products.repository.ProductRepositorySingleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductQueryServiceImpl implements ProductQueryService {

    ProductRepository productRepository;

    public ProductQueryServiceImpl() {
        productRepository = ProductRepositorySingleton.getINSTANCE();

    }

    @Override
    public Product getProductById(int id) {

//        for(Product product : products) {
//            if(product.getId() == id) {
//                this.shoppingCart.add(product);
//                return product;
//            }
//        }
        return null;
    }

    @Override
    public Product getProductByName(String name){
//
//        for(Product product : products) {
//            if(product.getName().equalsIgnoreCase(name)) {
//                // this.shoppingCart.add(product);
//                return product;
//            }
//        }
        return null;
    }

    @Override
    public boolean foundProduct(Product product) {
//        for(Product p : products) {
//            if(product.getId() == p.getId()) {
//                return true;
//            }
//        }
        return false;
    }

    @Override
    public List<Product> getAllProductsById(int id) {
//        List<Product> products = new ArrayList<>();
//
//        for (Product product : products) {
//            if (product.getId() == id) {
//                products.add(product);
//            }
//        }
        return null;

    }


    @Override
    public void showProducts() {
//        for (Product product : products) {
//            System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice());
//        }
    }

    @Override
    public void showShoppingCart() {
//        for (Product product : shoppingCart) {
//            System.out.println(product.getName());
//        }

    }

    @Override
    public void afisare(){
        System.out.println(this);
    }

//    @Override
//    public String toString(){
//        for(Product product : products) {
//            System.out.println(product);
//        }
//        return products.toString();
//    }

}
