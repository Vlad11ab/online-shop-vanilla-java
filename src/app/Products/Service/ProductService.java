package app.Products.Service;

import app.Products.Model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {

    private List<Product> products;
    private List<Product> shoppingCart;

    public ProductService() {
        products = new ArrayList<>();
        shoppingCart = new ArrayList<>();

        this.loadProducts();
    }

    private void loadProducts() {
        String filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/Products/Data/Products.txt";

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


    //Se afiseaza lista
    //Selectez produsul din lista
    //Parcurg documentul cu produse
    //Daca id-ul/numele coincide cu un produs din lista => cos.add()

    public void showShoppingCart() {
        for(Product product : shoppingCart) {
            System.out.println(product.getName());
        }

    }

    public void showProducts() {
        for(Product product : products) {
            System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice());
        }
    }

    public Product getProductById(int id) {

        for(Product product : products) {
            if(product.getId() == id) {
                this.shoppingCart.add(product);
                return product;
            }
        }
        return null;
    };

    public Product getProductByName(String name){

        for(Product product : products) {
            if(product.getName().equalsIgnoreCase(name)) {
                this.shoppingCart.add(product);
                return product;
            }
        }
        return null;
    }















}
