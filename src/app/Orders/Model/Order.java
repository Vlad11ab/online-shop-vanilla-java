package app.Orders.Model;

public class Order {
    private int customerId;
    private int ammount;
    private String orderAddress;

    //Constructor
    public Order(int customerId, int ammount, String orderAddress) {
        this.customerId = customerId;
        this.ammount = ammount;
        this.orderAddress = orderAddress;
    }

    //Constructor cu String
    public Order(String text){
        String [] tokens = text.split(",");
        this.customerId = Integer.parseInt(tokens[0]);
        this.ammount = Integer.parseInt(tokens[1]);
        this.orderAddress = tokens[2];
    }

    //Setters
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }
    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    //Getters
    public int getCustomerId() {
        return customerId;
    }
    public int getAmmount() {
        return ammount;
    }
    public String getOrderAddress() {
        return orderAddress;
    }

    @Override
    public String toString() {
        return this.customerId + "," + this.ammount + "," + this.orderAddress;
    }





}
