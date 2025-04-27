package app.system.cart;

import app.products.model.Product;

public class CartItem {

    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
       this.product = product;
        this.quantity = quantity;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String describeItem(){
        String text="";
        text+="Name: "+product.getName()+"\n";
        text+="Quantity: "+quantity+"\n";
        text+="Total price: "+(product.getPrice()*quantity)+"\n";

        return text;
    }



}
