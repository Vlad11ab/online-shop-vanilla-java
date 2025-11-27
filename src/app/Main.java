package app;


import app.orderdetail.model.OrderDetail;
import app.orderdetail.service.OrderDetailCommandService;
import app.orderdetail.service.OrderDetailCommandServiceSingleton;
import app.orderdetail.service.OrderDetailQueryService;
import app.orderdetail.service.OrderDetailQueryServiceSingleton;
import app.orders.model.Order;
import app.orders.service.OrderQueryService;
import app.orders.service.OrderQueryServiceSingleton;
import app.products.model.Product;
import app.users.repository.UserRepository;
import app.users.repository.UserRepositoryImpl;
import app.users.service.UserQueryService;
import app.users.service.UserQueryServiceImpl;
import app.view.ViewLogin;

import javax.swing.text.View;

public class Main {
    public static void main(String[] args) {

        ViewLogin viewLogin = new ViewLogin();




    }
}