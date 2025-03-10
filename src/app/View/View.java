package app.View;

import app.Customers.Model.Customer;
import app.Customers.Service.CustomerService;
import app.OrderDetail.Model.OrderDetail;
import app.OrderDetail.Service.OrderDetailService;
import app.Orders.Model.Order;
import app.Orders.Service.OrderService;
import app.Products.Model.Product;
import app.Products.Service.ProductService;

import java.util.Scanner;

public class View {
    private Customer customer;
    private CustomerService customerService;
    private OrderDetail orderDetail;
    private OrderDetailService orderDetailService;
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
        this.scanner = new Scanner(System.in);
        this.play();
    }

    public void meniu(){

        System.out.println("1. Adauga un produs in cos");
        System.out.println("2. Editeaza cosul");
        System.out.println("3. Trimite comanda");
        System.out.println("4. Sterge un produs din cos");
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
                default:
                    System.out.println("Select a valid option!");
            }
        }
    }


    //Functii
    private void select1(){

    }

    private void select2(){

    }

    private void select3(){

    }

    private void select4(){

    }







}
