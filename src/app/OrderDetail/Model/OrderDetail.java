package app.OrderDetail.Model;

public class OrderDetail {
    private int id;
    private int orderId;
    private float price;
    private int quantity;

    //Constructor
    public OrderDetail(int id, int orderId, float price, int quantity) {
        this.id = id;
        this.orderId = orderId;
        this.price = price;
        this.quantity = quantity;
    }

    //Constructor cu String
    public OrderDetail(String text) {
        String [] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.orderId = Integer.parseInt(tokens[1]);
        this.price = Float.parseFloat(tokens[2]);
        this.quantity = Integer.parseInt(tokens[3]);
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    //Getters
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return this.id + "," + this.orderId + "," + this.price + "," + this.quantity;
    }





}
