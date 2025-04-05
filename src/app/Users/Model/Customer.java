package app.Users.Model;

public class Customer extends User {
    private int id;
    private String defaultShippingAddress;
    private String country;
    private String phone;

    //Constructor
    public Customer(int id, String fullName, String email, String password, String defaultShippingAddress, String country, String phone) {
        super(id, fullName, email, password);
        this.id = id;
        this.defaultShippingAddress = defaultShippingAddress;
        this.country = country;
        this.phone = phone;
    }

    //Constructor cu string
    public Customer(String text){
        super(text);
        String [] tokens = text.split(",");
        //token[1] id, token[2] email, token[3] password token[3] fullName
        this.defaultShippingAddress = tokens[5];
        this.country = tokens[6];
        this.phone = tokens[7];
    }

    //Setters
    public void setId(int id){
        this.id = id;
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
    public void afisare(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + " defaultShippingAddress: " + this.defaultShippingAddress + "country: " + this.country + "phone: ";
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Customer){
            Customer c = (Customer)o;
            return true;
        }
        return false;
    }










}
