package app.orderdetail.service;

import app.orderdetail.model.OrderDetail;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderDetailQueryServiceImpl implements OrderDetailQueryService {

    private ArrayList<OrderDetail> orderdetails;

    public OrderDetailQueryServiceImpl() {
        orderdetails = new ArrayList<>();
    }

    @Override
    public void loadData() {

        try {
            String filepath = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/OrderDetail/Data/OrderDetails.txt";
            File file = new File(filepath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public  void saveData(){

        String filepath = "/Users/vlad11ab/Documents/mycode/OnlineStore/OnlineStore/src/app/OrderDetail/Data/OrderDetails.txt";
        try{
            FileWriter fileWriter = new FileWriter(filepath);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(this);
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String text="";
        for(int i = 0; i < orderdetails.size()-1; i++){
            text += orderdetails.get(i).toString() + "\n";
        }
        text += orderdetails.get(orderdetails.size()-1).toString();
        return text;
    }

    @Override
    public void afisare() {
        System.out.println(this);
    }



}
