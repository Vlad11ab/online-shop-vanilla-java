package app.View.Admin;

import app.Users.Model.Admin;
import app.Users.Service.UserService;

import java.util.Scanner;

public class ViewLoginAdmin {

    private UserService userService;
    private Scanner scanner;

    public ViewLoginAdmin() {
        this.userService = new UserService();
        this.scanner = new Scanner(System.in);
        this.play();

    }

    public void meniuLoginAdmin(){
        System.out.println("1->Login Admin");
    }

    public void play(){
        boolean running = true;

        while(running){
            this.meniuLoginAdmin();
            int choose = Integer.parseInt(scanner.nextLine());
            switch(choose){
                case 1:
                    this.select1();
                    break;
            }
        }
    }


    //Functii
    private void select1(){
        System.out.println("AdminName:");
        String adminName = scanner.next();
        System.out.println("AdminPassword:");
        String adminPassword = scanner.next();

        Admin admin = userService.getAdminForLogin(adminName, adminPassword);

        if(admin != null){
            System.out.println("Admin Login Success");

            ViewAdmin viewAdmin = new ViewAdmin(admin);
        }
        else System.out.println("Admin Login Failed");
    }


}
