package app.Customers.Service;

import app.Users.Model.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {

    private List<Customer> customers;
    private String filename;

    public CustomerService(){
        customers = new ArrayList<>();

        this.filename = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/Customers/Data/customers/Customers.txt";
        this.loadCustomers();
    }

    private void loadCustomers(){

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

    public void addCustomer (Customer customer){

        this.customers.add(customer);
    }

    public void removeCustomer (Customer customer){
        customers.remove(customer);
    }


    @Override
    public String toString() {
        String text="";
        for(int i = 0; i < customers.size()-1; i++){
            text += customers.get(i).toString() + "\n";
        }
        text += customers.get(customers.size()-1).toString();
        return text;
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

    public void showCustomers(){
        for(Customer customer : customers){
            System.out.println(customer.toString());
        }
    }

}
