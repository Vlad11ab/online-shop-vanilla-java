package app.view;

import app.orderdetail.service.OrderDetailCommandService;
import app.orderdetail.service.OrderDetailCommandServiceSingleton;
import app.orderdetail.service.OrderDetailQueryService;
import app.orderdetail.service.OrderDetailQueryServiceSingleton;
import app.orders.service.OrderCommandService;
import app.orders.service.OrderCommandServiceSingleton;
import app.orders.service.OrderQueryService;
import app.orders.service.OrderQueryServiceSingleton;
import app.products.service.ProductCommandService;
import app.products.service.ProductCommandServiceSingleton;
import app.products.service.ProductQueryService;
import app.products.service.ProductQueryServiceSingleton;
import app.users.model.Admin;
import app.users.model.Customer;
import app.users.service.UserCommandService;
import app.users.service.UserCommandServiceSingleton;
import app.users.service.UserQueryService;
import app.system.cart.Cart;
import app.users.service.UserQueryServiceSingleton;

import java.util.Scanner;

public class ViewAdmin {

    private Admin admin;
    private Customer customer;
    private UserCommandService userCommandService;
    private UserQueryService userQueryService;
    private ProductCommandService productCommandService;
    private ProductQueryService productQueryService;
    private OrderCommandService orderCommandService;
    private OrderQueryService orderQueryService;
    private OrderDetailCommandService orderDetailCommandService;
    private OrderDetailQueryService orderDetailQueryService;
    private Cart cart;
    private Scanner scanner;

    public ViewAdmin(Admin admin) {
        this.admin = admin;
        this.userCommandService = UserCommandServiceSingleton.getInstance();
        this.userQueryService = UserQueryServiceSingleton.getInstance();
        this.productCommandService = ProductCommandServiceSingleton.getInstance();
        this.productQueryService = ProductQueryServiceSingleton.getInstance();
        this.orderCommandService = OrderCommandServiceSingleton.getInstance();
        this.orderQueryService = OrderQueryServiceSingleton.getInstance();
        this.orderDetailCommandService = OrderDetailCommandServiceSingleton.getInstance();
        this.orderDetailQueryService = OrderDetailQueryServiceSingleton.getInstance();
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
        userQueryService.showUsers();
    }




}
