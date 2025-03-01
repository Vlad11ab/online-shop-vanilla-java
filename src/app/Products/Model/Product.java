package app.Products.Model;

public class Product {
    private int name;
    private String price;
    private String weight;
    private String category;
    private String stock;


    //Constructor
    public Product(int name, String price, String weight, String category, String stock) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.category = category;
        this.stock = stock;
    }

    //Constructor cu string
    public Product(String text){
        String [] tokens = text.split(",");
        this.name = Integer.parseInt(tokens[0]);
        this.price = tokens[1];
        this.weight = tokens[2];
        this.category = tokens[3];
        this.stock = tokens[4];
    }

    //Setters
    public void setName(int name){
        this.name = name;
    }
    public void setPrice(String price){
        this.price = price;
    }
    public void setWeight(String weight){
        this.weight = weight;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setStock(String stock){
        this.stock = stock;
    }

    //Getters
    public int getName(){
        return name;
    }
    public String getPrice(){
        return price;
    }
    public String getWeight(){
        return weight;
    }
    public String getCategory(){
        return category;
    }
    public String getStock(){
        return stock;
    }

    @Override
    public String toString(){
        return this.name + " " + this.price + " " + this.weight + " " + this.category + " " + this.stock + " ";
    }






}
