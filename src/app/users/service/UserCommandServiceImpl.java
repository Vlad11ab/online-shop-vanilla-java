package app.users.service;

import app.users.model.Admin;
import app.users.model.Customer;
import app.users.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserCommandServiceImpl implements UserCommandService {

    private List<User> users;

    private String filename;

    public UserCommandServiceImpl() {
        users = new ArrayList<>();

        this.filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/users/data/Users.txt";
        this.loadData();
    }


    @Override
    public void loadData() {
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

    @Override
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

    @Override
    public void addCustomer (User user){
        if(user instanceof Customer) {
            Customer customer = (Customer) user;
            this.users.add(customer);
        }

    }

    @Override
    public void removeCustomer (User user){
        if(user instanceof Customer) {
            Customer customer = (Customer) user;
            users.remove(customer);
        }

    }

    @Override
    public void saveData() {

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
