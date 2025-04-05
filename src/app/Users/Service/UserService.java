package app.Users.Service;

import app.Users.Model.Admin;
import app.Users.Model.Customer;
import app.Users.Model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    private List<User> users;

    private String filename;

    public UserService() {
        users = new ArrayList<>();

        this.filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/Users/Data/Users.txt";
        this.loadUsers();
    }

    private void loadUsers() {
        File file = new File(filename);

        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(",");
                    switch (split[0]) {
                        case "CUSTOMER":
                            this.users.add(new Customer(line));
                            break;
                        case "ADMIN":
                            this.users.add(new Admin(line));
                            break;
                    }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public Admin getAdminForLogin(String username, String password) {
        for (User user : users) {

            if(user instanceof Admin){
                Admin admin = (Admin) user;
                if(admin.getFullName().equals(username) && admin.getPassword().equals(password)){
                    return admin;
                }
            }

        }
        return null;

    }

    public void showUsers(){

        for(User user : users){

            if(user instanceof Admin){
                Admin admin = (Admin) user;
                admin.afisare();
            }

            else if(user instanceof Customer){
                Customer customer = (Customer) user;
                customer.afisare();
            }

        }


    }









}

