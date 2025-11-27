package app.products.repository;

import app.products.model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> products;
    private List<Product> shoppingCart;

    String productfilepath;


    public ProductRepositoryImpl() {
        products = new ArrayList<>();
        shoppingCart = new ArrayList<>();

        productfilepath = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/products/data/Products.txt";

        this.loadData();
    }

    public void loadData() {
        File file = new File(productfilepath);

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

    public void saveData() {

        File file = new File(productfilepath);
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(this);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
