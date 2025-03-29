package app.system.cart;

import app.Products.Model.Product;
import app.Products.Service.ProductService;


import javax.sql.XAConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.sql.Types.NULL;

public class Cart {

    private ArrayList<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }
    //todo:add product
    //todo:remove product
    //todo:edit product

    public void addToCart(CartItem cartItem) {

        CartItem item = getCartItemById(cartItem.getProduct().getId());
        //todo:verifcare existenta cos
        if (item == null) {
            this.cartItems.add(cartItem);
        } else {
            this.incrementQuantity(item);
        }


    }

//    public void addToCart(CartItem cartItem) {
//        for (CartItem ci : cartItems) {
//            if (ci.getProduct().getId() == cartItem.getProduct().getId()) {
//                incrementQuantity(ci);
//                return;
//            }
//        }
//
//        this.cartItems.add(cartItem);
//    }

    public void incrementQuantity(CartItem cartItem) {
        int cantitate = cartItem.getQuantity();
        cantitate += 1;
        cartItem.setQuantity(cantitate);
    }

    //todo:functie ce verifica daca produsl exista in cos
    public boolean foundItem(int productId) {
        for (CartItem ci : this.cartItems) {
            if (ci.getProduct().getId() == productId) {
                return true;
            }
        }
        return false;
    }


    public CartItem getCartItemById(int productId) {
        for (CartItem ci : this.cartItems) {
            if (ci.getProduct().getId() == productId) {
                return ci;
            }
        }
        return null;
    }

    public void removeFromCart(CartItem cartItem) {
        this.cartItems.remove(cartItem);
    }



    public void showCartItems() {

        for (CartItem ci : this.cartItems) {
            System.out.println(ci.describeItem());
        }
    }




    public List<CartItem> getCartItems() {
        return this.cartItems;
    }

    public int totalPrice() {
        int totalPrice = 0;
        for (CartItem ci : this.cartItems) {
            totalPrice += ci.getProduct().getPrice()*ci.getQuantity();
        }

        return totalPrice;
    }



}




