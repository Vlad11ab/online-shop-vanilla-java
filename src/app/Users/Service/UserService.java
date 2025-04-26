package app.Users.Service;

import app.Users.Model.Admin;
import app.Users.Model.Customer;
import app.Users.Model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    private static UserService instance;

    private List<User> users;

    private String filename;

    private UserService() {
        users = new ArrayList<>();

        this.filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/Users/Data/Users.txt";
        this.loadUsers();
    }

    public static UserService getInstance() {
        if(instance == null) {
            instance = new UserService();
        }
        return instance;
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

    public User getUserForLogin(String username, String password) {
        for (User user : users) {

            if(user instanceof Customer) {
                Customer customer = (Customer) user;
                if(customer.getFullName().equals(username) && customer.getPassword().equals(password)){
                    return customer;
                }
            }
            else if(user instanceof Admin) {
                Admin admin = (Admin) user;
                if(admin.getAdminName().equals(username) && admin.getAdminPassword().equals(password)){
                    return admin;
                }
            }

        }
        return null;

    }


    public void addCustomer (User user){
        if(user instanceof Customer) {
            Customer customer = (Customer) user;
            this.users.add(customer);
        }

    }

    public void removeCustomer (User user){
        if(user instanceof Customer) {
            Customer customer = (Customer) user;
            users.remove(customer);
        }

    }

    public void showCustomers(){
        for(User user : users) {

            if(user instanceof Customer) {
                Customer customer = (Customer) user;
                System.out.println(customer.toString());
            }

        }

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


    public  void saveAll(){

        File file = new File(filename);
        try{
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(this);
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }







}

