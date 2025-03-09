package app.View;

import app.Customers.Model.Customer;
import app.Customers.Service.CustomerService;
import app.OrderDetail.Model.OrderDetail;
import app.OrderDetail.Service.OrderDetailService;
import app.Orders.Model.Order;
import app.Orders.Service.OrderService;
import app.Products.Model.Product;
import app.Products.Service.ProductService;
import app.system.cart.Cart;
import app.system.cart.CartItem;


import java.util.Scanner;

public class View {
    private Customer customer;
    private CustomerService customerService;
    private OrderDetail orderDetail;
    private OrderDetailService orderDetailService;
    private Cart cart;
    private Order order;
    private OrderService orderService;
    private Product product;
    private ProductService productService;
    private Scanner scanner;

    public View() {
        this.customerService = new CustomerService();
        this.orderDetailService = new OrderDetailService();
        this.orderService = new OrderService();
        this.productService = new ProductService();
        this.cart = new Cart();
        this.scanner = new Scanner(System.in);
        this.play();
    }

    public void meniu(){

        System.out.println("1. Adauga un produs in cos");
        System.out.println("2. Editeaza cosul");
        System.out.println("3. Trimite comanda");
        System.out.println("4. Sterge un produs din cos");
        System.out.println("5. Afisare produse");
        System.out.println("6. Arata-mi produsele din cos");


    }

    private void play(){

        boolean running = true;

        while(running){
            this.meniu();
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    this.select1();
                    break;
                case 2:
                    this.select2();
                    break;
                case 3:
                    this.select3();
                    break;
                case 4:
                    this.select4();
                    break;
                case 5:
                    this.select5();
                    break;
                case 6:
                    this.select6();
                    break;
                default:
                    System.out.println("Select a valid option!");
            }
            System.out.println("");
        }
    }


    //Functii

    private void select6(){
        System.out.println("Cosul dumneavoastra contine: ");
        cart.showCartItems();
    }

    private void select5(){
        System.out.println("Acestea sunt produsele disponibile: ");
        productService.showProducts();

    }

    private void select4(){

    }

    private void select3(){

    }

    private void select2(){

    }

    private void select1(){
        System.out.println("Lista produselor: ");
        productService.showProducts();

        System.out.println("Introduceti numele produsului urmat de cantitate");
        String productName = scanner.nextLine();
        Product product = productService.getProductByName(productName);
        //todo:veriific existenta produsulu
        //todo:Creez un cartItem cu detaliile din produs
         if(productService.foundProduct(product)){
             CartItem cartItem = new CartItem(product,1);
             cart.addToCart(cartItem);
         }
    }










}
