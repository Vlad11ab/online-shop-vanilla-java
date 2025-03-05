package app.OrderDetail.Model;

public class OrderDetail {
    private int id;
    private int orderId;
    private int productId;
    private float price;
    private int quantity;

    //Constructor
    public OrderDetail(int id, int orderId,int productId, float price, int quantity) {
        this.productId = productId;
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
        this.productId = Integer.parseInt(tokens[2]);
        this.price = Float.parseFloat(tokens[3]);
        this.quantity = Integer.parseInt(tokens[4]);
    }

    //Setters
   public void setId(int id) {
        this.id = id;
   }
   public void setOrderId(int orderId) {
        this.orderId = orderId;
   }
   public void setProductId(int productId) {
        this.productId = productId;
   }
   public void setPrice(float price) {
        this.price = price;
   }
   public void setQuantity(int quantity) {
        this.quantity = quantity;
   }

    //Getters
   public int getId() {
        return id;
   }
   public int getOrderId() {
        return orderId;
   }
   public int getProductId() {
        return productId;
   }
   public float getPrice() {
        return price;
   }
   public int getQuantity() {
        return quantity;
   }

    @Override
    public String toString() {
        return this.id + "," + this.orderId + "," + this.productId + "," + this.price + "," + this.quantity;
    }





}
