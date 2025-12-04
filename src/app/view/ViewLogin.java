package app.view;

import app.users.exceptions.UserAlreadyExistException;
import app.users.exceptions.UserNotFoundException;
import app.users.model.Admin;
import app.users.model.Customer;
import app.users.model.User;
import app.users.service.UserCommandService;
import app.users.service.UserCommandServiceSingleton;
import app.users.service.UserQueryService;
import app.users.service.UserQueryServiceSingleton;

import java.util.Scanner;

public class ViewLogin {

    private UserCommandService userCommandService;
    private UserQueryService userQueryService;
    private Scanner scanner;

    public ViewLogin(){
        this.userCommandService = UserCommandServiceSingleton.getINSTANCE();
        this.userQueryService = UserQueryServiceSingleton.getINSTANCE();
        this.scanner = new Scanner(System.in);
        this.play();
    }

    public void LoginMenu(){
        System.out.println("1.Login");
        System.out.println("2.Register");
    }

    public void play(){
        boolean running = true;

                while (running) {
                    this.LoginMenu();
                    int choose = Integer.parseInt(scanner.nextLine());
                    switch (choose) {
                        case 1:
                            this.select1();
                            break;
                        case 2:
                            this.select2();
                            break;
                        default:
                            System.out.println("Invalid option!");
                    }
                }

    }



    //Functii

    private void select1(){
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        try{
            User user = userQueryService.loginUser(username,password);
            if (user instanceof Customer) {
                Customer customer = (Customer) user;
                System.out.println("Successfuly logged in as Customer: " + customer.getUsername());
                ViewCustomer viewCustomer = new ViewCustomer(customer);
            } else if (user instanceof Admin) {
                Admin admin = (Admin) user;
                System.out.println("Successfuly logged in as Admin: " + admin.getAdminName());
                ViewAdmin viewAdmin = new ViewAdmin(admin);
            } else System.out.println("Invalid Credentials!");
        }catch (UserNotFoundException userNotFoundException){
            System.out.println(userNotFoundException.getMessage());

    }


    }

    private void select2(){
        System.out.println("Introduceti un username: ");
        String registrationUsername = scanner.nextLine();
        System.out.println("Introduceti o parola: ");
        String registrationPassword = scanner.nextLine();
        System.out.println("Introduceti adresa de email: ");
        String registrationemail = scanner.nextLine();
        System.out.println("Introduceti numele complet: ");
        String registrationFullName = scanner.nextLine();

        User user = new Customer.CustomerBuilder()
                .id(100)
                .email(registrationemail)
                .fullName(registrationFullName)
                .username(registrationUsername)
                .password(registrationPassword)
                .build();

        try {
            userCommandService.registerUser(user);
        } catch (UserAlreadyExistException userAlreadyExistException) {
            System.out.println(userAlreadyExistException.getMessage());
        }


    }






}
