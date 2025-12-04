package app.products.repository;

import app.products.model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> products;
    private List<Product> shoppingCart;

    String filename;


    public ProductRepositoryImpl() {
        products = new ArrayList<>();
        shoppingCart = new ArrayList<>();

        filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/products/data/Products.txt";

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
    public Optional<Product> findProductsById(int id) {

        return products.stream().filter(product -> product.getId() == id).findAny();
    }

    @Override
    public Optional<Product> findProductById(int id) {

        return products.stream().filter(product -> product.getId() == id).findAny();
    }

    @Override
    public Optional<Product> findProductByName(String name) {

        return products.stream().filter(product -> product.getName().equals(name)).findAny();
    }

    @Override
    public boolean foundProduct(Product product) {

        if (product == null){
            return false;
        }else return products.stream().anyMatch(p -> p.equals(product));
    }

    @Override
    public List<Product> listProducts() {

        return products;
    }
}
