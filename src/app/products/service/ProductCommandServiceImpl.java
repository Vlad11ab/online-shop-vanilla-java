package app.products.service;

import app.products.model.Product;
import app.products.repository.ProductRepository;
import app.products.repository.ProductRepositoryImpl;
import app.products.repository.ProductRepositorySingleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductCommandServiceImpl implements ProductCommandService {

    ProductRepository productRepository;

    public ProductCommandServiceImpl() {
        productRepository = ProductRepositorySingleton.getINSTANCE();

    }



}
