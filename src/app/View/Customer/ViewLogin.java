package app.View.Customer;

import app.Users.Model.Customer;
//import app.Customers.OldCustomerService.CustomerService;
import app.Users.Service.UserService;

import java.util.Scanner;

public class ViewLogin {

    private UserService userService;
    private Scanner scanner;

    public ViewLogin(){
        this.userService = new UserService();
        this.scanner = new Scanner(System.in);
        this.play();
    }

    public void meniuLogin(){
        System.out.println("1.Login");
        System.out.println("2.Register");
    }

    public void play(){
        boolean running = true;

                while (running) {
                    this.meniuLogin();
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

        Customer customer = userService.getCustomerForLogin(username, password); //username = fullName
        if(customer != null){
            System.out.println("Login Successful!");

            View view = new View(customer);

        }
    }

    private void select2(){

    }






}
