package app.View.Admin;

import app.OrderDetail.Service.OrderDetailService;
import app.Orders.Service.OrderService;
import app.Products.Service.ProductService;
import app.Users.Model.Admin;
import app.Users.Model.Customer;
import app.Users.Service.UserService;
import app.system.cart.Cart;

import java.util.Scanner;

public class ViewAdmin {

    private Admin admin;
    private Customer customer;
    private UserService userService;
    private ProductService productService;
    private OrderService orderService;
    private OrderDetailService orderDetailService;
    private Cart cart;
    private Scanner scanner;

    public ViewAdmin(Admin admin) {
        this.admin = admin;
        this.userService = new UserService();
        this.productService = new ProductService();
        this.orderService = new OrderService();
        this.orderDetailService = new OrderDetailService();
        this.cart = new Cart();
        this.scanner = new Scanner(System.in);
        this.play();
    }

    public void meniuAdmin() {

        System.out.println("1->Lista Useri");

    }

    public void play() {
        boolean running = true;

        while (running) {
            this.meniuAdmin();

            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    this.select1();
                    break;
            }
        }
    }


    //Functii
    public void select1(){
        userService.showUsers();
    }




}
