package app.Products.Model;

public class Product {
    private int id;
    private int name;
    private String price;  //lei
    private String weight;  //gr/ml
    private String category;
    private String stock; //buc


    //Constructor
    public Product(int id, int name, String price, String weight, String category, String stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.category = category;
        this.stock = stock;
    }

    //Constructor cu string
    public Product(String text){
        String [] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.name = Integer.parseInt(tokens[1]);
        this.price = tokens[2];
        this.weight = tokens[3];
        this.category = tokens[4];
        this.stock = tokens[5];
    }

    //Setters
    public void setId(int id){ this.id = id; }
    public void setName(int name){ this.name = name; }
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
    public int getId(){ return id; }
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
        return this.id + " " + this.name + " " + this.price + " " + this.weight + " " + this.category + " " + this.stock + " ";
    }






}
