package app.view;

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
        this.userCommandService = UserCommandServiceSingleton.getInstance();
        this.userQueryService = UserQueryServiceSingleton.getInstance();
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

        User user = userCommandService.getUserForLogin(username, password); //username = fullName

        if(user != null){

            if(user instanceof Customer){
                Customer customer = (Customer) user;
                System.out.println("Login Successful!");
                ViewCustomer viewCustomer = new ViewCustomer(customer);
            }
            else if(user instanceof Admin){
                Admin admin = (Admin) user;
                System.out.println("Admin Login Successful!");
                ViewAdmin viewAdmin = new ViewAdmin(admin);
            }
        }else{
            System.out.println("Invalid username or password!");
        }


    }

    private void select2(){

    }






}
