package app.Users.Model;


public class Admin extends User {
    private int id;
    private String adminName;
    private String adminPassword;

    public Admin(int id, String fullName, String email, String password, String adminName, String adminPassword) {
        super(id, fullName, email, password);
        this.id = id;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public Admin(String text){
        super(text);
        String [] tokens = text.split(" ");
        //token[1] id, token[2] email, token[3] password token[3] fullName
        this.adminName = tokens[5];
        this.adminPassword = tokens[6];
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getAdminName() {
        return adminName;
    }
    public String getAdminPassword() {
        return adminPassword;
    }


    @Override
    public void afisare() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + "Admin{" + "adminName=" + this.adminName + ", adminPassword=" + this.adminPassword + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Admin) {
            Admin admin = (Admin) o;
            return true;
        }
        return false;
    }



}
