package app.View;

import app.Users.Model.Admin;
import app.Users.Model.Customer;
import app.Users.Model.User;
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

        User user = userService.getUserForLogin(username, password); //username = fullName

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
