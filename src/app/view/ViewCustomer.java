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
import app.users.model.Customer;
import app.orderdetail.model.OrderDetail;
import app.orders.model.Order;
import app.products.model.Product;
import app.users.service.UserCommandService;
import app.users.service.UserCommandServiceSingleton;
import app.users.service.UserQueryService;
import app.system.cart.Cart;
import app.system.cart.CartItem;
import app.users.service.UserQueryServiceSingleton;


import java.util.List;
import java.util.Scanner;

public class ViewCustomer {
    private Customer customer;
    private UserCommandService userCommandService;
    private UserQueryService userQueryService;
    private OrderDetailCommandService orderDetailCommandService;;
    private OrderDetailQueryService orderDetailQueryService;
    private Cart cart;
    private OrderCommandService orderCommandService;
    private OrderQueryService orderQueryService;
    private ProductCommandService productCommandService;
    private ProductQueryService productQueryService;
    private Scanner scanner;

    public ViewCustomer(Customer customer){
        this.customer = customer;
        this.userCommandService = UserCommandServiceSingleton.getInstance();
        this.userQueryService = UserQueryServiceSingleton.getInstance();
        this.orderDetailCommandService = OrderDetailCommandServiceSingleton.getInstance();
        this.orderDetailQueryService = OrderDetailQueryServiceSingleton.getInstance();
        this.orderCommandService = OrderCommandServiceSingleton.getInstance();
        this.orderQueryService = OrderQueryServiceSingleton.getInstance();
        this.productCommandService = ProductCommandServiceSingleton.getInstance();
        this.productQueryService = ProductQueryServiceSingleton.getInstance();
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
        orderQueryService.showAllOrdersIds();
    }

    private void select8(){

        //todo:  cere order Id de la user
            System.out.println("Introdu Id-ul comenzii tale: ");
            int orderId = Integer.parseInt(scanner.nextLine());


            if(orderQueryService.checkOrderId(orderId)){

                List <OrderDetail> orderdetails = orderDetailQueryService.getOrderDetailsByOrderId(orderId);

                    for(OrderDetail orderDetail : orderdetails) {
                        if (orderDetail.getOrderId() == orderId) {
                            System.out.println("Id:" + orderDetail.getId() + " OrderId:" + orderDetail.getOrderId() + " ProductId:" + orderDetail.getProductId() + " Quantity:" + orderDetail.getQuantity());
                        }
                    }

            }
            else System.out.println("Id invalid!");
        }

    private void select7(){
        System.out.println("Comenzile clientului sunt: ");


        List<Order> clientOrders = this.orderQueryService.getOrdersByCustomerId(customer.getId());
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
        productQueryService.showProducts();


    }

    private void select4(){
        System.out.println("Produsele din cos: ");
        cart.showCartItems();

        System.out.println("Introduceti numele produsului pe care doriti sa-l stergeti din cos: ");
        String productsname = scanner.nextLine();

        Product product = productQueryService.getProductByName(productsname);

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

        if(!choice.equalsIgnoreCase("DA")){
            System.out.println("Comanda nu va fi trimisa ");
        }
        else {
            List<CartItem> cartItems = cart.getCartItems();


            Order order =  new Order(this.customer.getId(),this.cart.totalPrice(),"aasdad");
            this.orderCommandService.addOrder(order);
            for (CartItem cartItem : cartItems) {
                OrderDetail orderDetail = new OrderDetail(order.getId(), cartItem.getProduct().getId(), cartItem.getProduct().getId(), cartItem.getQuantity());
                orderDetailCommandService.addOrderDetail(orderDetail);

            }

            this.orderCommandService.saveData();
            this.orderDetailCommandService.saveData();
            System.out.println("Comanda cu Id-ul:" + order.getId()+ " a fost trimisa cu succes");
        }



    }

    private void select2(){
        System.out.println("Produsele din cos: ");
        cart.showCartItems();

        System.out.println("Introduceti numele produsului pe care doriti sa-l editati: ");
        String productname = scanner.nextLine();

        Product product = productQueryService.getProductByName(productname);

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
        productQueryService.showProducts();

        System.out.println("Introduceti numele produsului dorit: ");
        String productName = scanner.nextLine();
        Product product = productQueryService.getProductByName(productName);
        //todo:veriific existenta produsului
        //todo:Creez un cartItem cu detaliile din produs
         if(productQueryService.foundProduct(product)){
             CartItem cartItem = new CartItem(product,1);
             cart.addToCart(cartItem);
         }
    }












}
