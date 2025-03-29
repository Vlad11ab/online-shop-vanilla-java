package app.Customers.Service;

import app.Customers.Model.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {

    private List<Customer> customers;

    public CustomerService(){
        customers = new ArrayList<>();

        this.loadCustomers();
    }

    private void loadCustomers(){
        String filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/Customers/Data/customers/Customers.txt";

        File file = new File(filename);

        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                Customer customer = new Customer(line);
                customers.add(customer);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public Customer getCustomerForLogin(String fullName, String password){
        for(Customer customer : customers){
            if(customer.getFullName().equals(fullName) && customer.getPassword().equals(password));
            return customer;
        }
        return null;
    }





}
