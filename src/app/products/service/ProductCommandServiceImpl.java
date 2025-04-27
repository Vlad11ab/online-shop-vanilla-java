package app.products.service;

import app.products.model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductCommandServiceImpl implements ProductCommandService {

    private List<Product> products;
    private List<Product> shoppingCart;

    String filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/Products/Data/Products.txt";


    public ProductCommandServiceImpl() {
        products = new ArrayList<>();
        shoppingCart = new ArrayList<>();

        this.loadData();
    }

    public void loadData() {
        File file = new File(filename);

        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Product product = new Product(line);
                products.add(product);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveData() {

        File file = new File(filename);
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(this);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getProductById(int id) {

        for(Product product : products) {
            if(product.getId() == id) {
                this.shoppingCart.add(product);
                return product;
            }
        }
        return null;
    }

    @Override
    public Product getProductByName(String name){

        for(Product product : products) {
            if(product.getName().equalsIgnoreCase(name)) {
                // this.shoppingCart.add(product);
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean foundProduct(Product product) {
        for(Product p : products) {
            if(product.getId() == p.getId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Product> getAllProductsById(int id) {
        List<Product> products = new ArrayList<>();

        for (Product product : products) {
            if (product.getId() == id) {
                products.add(product);
            }
        }
        return products;

    }







}
