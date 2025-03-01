package app.Customers.Model;

public class Customer {
    private int id;
    private String email;
    private String password;
    private String fullName;
    private String defaultShippingAddress;
    private String country;
    private String phone;

    //Constructor
    public Customer(int id, String email, String password, String fullName, String defaultShippingAddress, String Country, String phone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.defaultShippingAddress = defaultShippingAddress;
        this.country = Country;
        this.phone = phone;
    }

    //Constructor cu string
    public Customer(String text){
        String [] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.email = tokens[1];
        this.password = tokens[2];
        this.fullName = tokens[3];
        this.defaultShippingAddress = tokens[4];
        this.country = tokens[5];
        this.phone = tokens[6];
    }

    //Setters
    public void setId(int id){
        this.id = id;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public void setDefaultShippingAddress(String defaultShippingAddress){
        this.defaultShippingAddress = defaultShippingAddress;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    //Getters
    public int getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getFullName(){
        return fullName;
    }
    public String getDefaultShippingAddress(){
        return defaultShippingAddress;
    }
    public String getCountry(){
        return country;
    }
    public String getPhone(){
        return phone;
    }

    @Override
    public String toString(){
        return this.id + " " + this.email + " " + this.password + " " + this.fullName + " " + this.defaultShippingAddress + " " + this.country + " " + this.phone;
    }






}
