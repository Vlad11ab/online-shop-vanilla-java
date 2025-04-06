package app.Users.Model;

public abstract class User {
    private int id;
    private String fullName;
    private String email;
    private String password;

    public User(int id, String fullName, String email, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public User(String text){
        String [] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[1]);
        this.email = tokens[2];
        this.password = tokens[3];
        this.fullName = tokens[4];

    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }

    //Getters
    public int getId(){
        return id;
    }
    public String getFullName(){
        return fullName;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }







    @Override
    public String toString(){
        return "id: " + this.id + ", fullName: " + this.fullName + ", email: " + this.email + ", password: " + this.password;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof User){
            User u = (User) o;
            return true;
        }
        return false;
    }


    public void afisare(){
        System.out.println(this);
    }








}
