package app.users.model;

public abstract class User {
    private int id;
    private String fullName;
    private String email;
    private String username;
    private String password;

    public User(int id, String fullName, String email, String username, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    private User (UserBuilder builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.username = builder.username;
        this.password = builder.password;
    }

    public static class UserBuilder {
        private int id;
        private String fullName;
        private String email;
        private String username;
        private String password;

        public UserBuilder id(int id) {
            this.id = id;
            return this;
        }

        public UserBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;

        }
    }

    public User(String text){
        String [] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[1]);
        this.fullName = tokens[2];
        this.email = tokens[3];
        this.username = tokens[4];
        this.password = tokens[5];


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
    public void setUsername(String username) {
        this.username = username;
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
    public String getUsername() {
        return username;
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
