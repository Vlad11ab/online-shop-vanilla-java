package app.products.service;

import app.products.model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductQueryServiceImpl implements ProductQueryService {

    private List<Product> products;
    private List<Product> shoppingCart;
    private String filename;

    public ProductQueryServiceImpl() {
        products = new ArrayList<>();
        shoppingCart = new ArrayList<>();

        this.filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/products/data/Products.txt";

        this.loadData();
    }

    @Override
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
    public void showProducts() {
        for (Product product : products) {
            System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice());
        }
    }

    @Override
    public void showShoppingCart() {
        for (Product product : shoppingCart) {
            System.out.println(product.getName());
        }

    }

    @Override
    public void afisare(){
        System.out.println(this);
    }

    @Override
    public String toString(){
        for(Product product : products) {
            System.out.println(product);
        }
        return products.toString();
    }

}
