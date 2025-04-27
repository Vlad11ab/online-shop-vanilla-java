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

public class UserQueryServiceImpl implements UserQueryService {

    private List<User> users;

    private String filename;

    public UserQueryServiceImpl() {
        users = new ArrayList<>();

        this.filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/Users/Data/Users.txt";
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
    public void showCustomers() {
        for(User user : users) {

            if(user instanceof Customer) {
                Customer customer = (Customer) user;
                System.out.println(customer.toString());
            }

        }

    }

    @Override
    public void showUsers() {

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
