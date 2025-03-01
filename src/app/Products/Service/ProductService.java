package app.Products.Service;

import app.Products.Model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {

    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();

        this.loadProducts();
    }

    private void loadProducts() {
        String filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app.Orders/Data/app.Orders.txt";

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








}
