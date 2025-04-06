package app.View.Customer;

import app.Users.Model.Customer;
//import app.Customers.OldCustomerService.CustomerService;
import app.OrderDetail.Model.OrderDetail;
import app.OrderDetail.Service.OrderDetailService;
import app.Orders.Model.Order;
import app.Orders.Service.OrderService;
import app.Products.Model.Product;
import app.Products.Service.ProductService;
import app.Users.Service.UserService;
import app.system.cart.Cart;
import app.system.cart.CartItem;


import java.util.List;
import java.util.Scanner;

public class View {
    private Customer customer;
//    private CustomerService customerService;
    private UserService userService;
    private OrderDetailService orderDetailService;
    private Cart cart;
    private OrderService orderService;
    private ProductService productService;
    private Scanner scanner;

    public View(Customer customer){
        this.customer = customer;
        this.userService = new UserService();
//        this.customerService = new CustomerService();
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
        //functie ce ne afiseaza comenziile
        System.out.println("7. Afiseaza comenzile");

        //functice ce ne arata detaliile unei comenzo
        System.out.println("8. Afisare detaliile unei comenzi");


        //test
        System.out.println("9. Afiseaza id-urile comenzilor");

    }

    //Trimite comanda
    //din cartItems iau id-urile produselor
    //trimit id-urile produselor in orders, mai multe produse ajungand intr-un order, comanda avand un orderId

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
                case 7:
                    this.select7();
                    break;
                case 8:
                    this.select8();
                    break;
                case 9:
                    this.select9();
                    break;
                default:
                    System.out.println("Select a valid option!");
            }
            System.out.println("");
        }
    }


    //Functii
    private void select9(){
        orderService.showAllOrdersIds();
    }

    private void select8(){

        //todo:  cere order Id de la user
            System.out.println("Introdu Id-ul comenzii tale: ");
            int orderId = Integer.parseInt(scanner.nextLine());


            if(orderService.checkOrderId(orderId)){

                List <OrderDetail> orderdetails = orderDetailService.getOrderDetailsByOrderId(orderId);

                    for(OrderDetail orderDetail : orderdetails) {
                        if (orderDetail.getOrderId() == orderId) {
                            System.out.println("Id:" + orderDetail.getId() + " OrderId:" + orderDetail.getOrderId() + " ProductId:" + orderDetail.getProductId() + " Quantity:" + orderDetail.getQuantity());
                        }
                    }

            }
            else System.out.println("Id invalid!");
        }


//        //todo: getAllProductsByOiD din productssERVICE
//        List <Order> clientOrders = this.orderService.getOrdersByCustomerId(customer.getId());
//
//
//        for(Order order : clientOrders){
//            for(OrderDetail orderDetail : orderdetails) {
//            System.out.println(orderDetail);
//            }
//
//        }


    private void select7(){
        System.out.println("Comenzile clientului sunt: ");


        List<Order> clientOrders = this.orderService.getOrdersByCustomerId(customer.getId());
        for(Order order : clientOrders){
            System.out.println("Comanda: " + order + " cu ID-ul: " + order.getId());

        }
    }

    private void select6(){
        System.out.println("Cosul dumneavoastra contine: ");
        cart.showCartItems();
    }

    private void select5(){
        System.out.println("Lista produselor: ");
        productService.showProducts();


    }

    private void select4(){
        System.out.println("Produsele din cos: ");
        cart.showCartItems();

        System.out.println("Introduceti numele produsului pe care doriti sa-l stergeti din cos: ");
        String productsname = scanner.nextLine();

        Product product = productService.getProductByName(productsname);

        if(product == null){
            System.out.println("Produsul nu exista!");
        }

        CartItem cartItem = cart.getCartItemById(product.getId());

        if(cartItem == null){
            System.out.println("Produsul nu exista in cos!");
        }

        cart.removeFromCart(cartItem);
        System.out.println("Produsul " + product.getName() + " a fost sters!");

    }

    private void select3(){
        System.out.println("Produsele din cos: ");
        cart.showCartItems();

        System.out.println("Doriti sa trimiteti comanda?   R:DA/NU ");
        String choice = scanner.nextLine();

        if(!choice.equals("DA")){
            System.out.println("Comanda nu va fi trimisa ");
        }
        else {
            List<CartItem> cartItems = cart.getCartItems();

            int orderId = orderService.generateOrderID();
            Order order =  new Order(orderId,this.customer.getId(),this.cart.totalPrice(),"aasdad");
            for (CartItem cartItem : cartItems) {
                int orderDetailsId = orderDetailService.generateOrderID();
                OrderDetail orderDetail = new OrderDetail(orderDetailsId, orderId, cartItem.getProduct().getId(), cartItem.getProduct().getId(), cartItem.getQuantity());
                orderDetailService.addOrderDetail(orderDetail);

            }
            this.orderService.addOrder(order);
            this.orderService.saveAll();
            this.orderDetailService.saveAll();
            System.out.println("Comanda cu Id-ul:" + order.getId()+ " a fost trimisa cu succes");
        }



    }

    private void select2(){
        System.out.println("Produsele din cos: ");
        cart.showCartItems();

        System.out.println("Introduceti numele produsului pe care doriti sa-l editati: ");
        String productname = scanner.nextLine();

        Product product = productService.getProductByName(productname);

        if(product == null){
            System.out.println("Produsul nu exista!");
            return;
        }


        CartItem cartItem=cart.getCartItemById(product.getId());

        if(cartItem == null){

            System.out.println("Produsul nu exista in cos!");
        }


        //logica editare cos
        System.out.println("Introduceti cantitatea dorita: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        cartItem.setQuantity(quantity);



    }

    private void select1(){
        System.out.println("Lista produselor: ");
        productService.showProducts();

        System.out.println("Introduceti numele produsului dorit: ");
        String productName = scanner.nextLine();
        Product product = productService.getProductByName(productName);
        //todo:veriific existenta produsului
        //todo:Creez un cartItem cu detaliile din produs
         if(productService.foundProduct(product)){
             CartItem cartItem = new CartItem(product,1);
             cart.addToCart(cartItem);
         }
    }












}
