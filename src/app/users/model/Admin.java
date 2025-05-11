package app.users.model;


public class Admin extends User {
//    private int id;
    private String adminName;
    private String adminPassword;

    public Admin(int id, String email, String fullName, String password, String adminName, String adminPassword) {
        super(id, fullName, email, password);
//        this.id = id;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public Admin(String text){
        super(text);
        String [] tokens = text.split(",");
        //token[1] id, token[2] email, token[3] password token[4] fullName
        this.adminName = tokens[5];
        this.adminPassword = tokens[6];
    }

    private Admin (AdminBuilder builder){
        super(builder.id, builder.fullName, builder.email, builder.password);
        this.adminName = builder.adminName;
        this.adminPassword = builder.adminPassword;
    }

    public static class AdminBuilder {
        private int id;
        private String fullName;
        private String email;
        private String password;
        private String adminName;
        private String adminPassword;

        public AdminBuilder id(int id){
            this.id = id;
            return this;
        }

        public AdminBuilder fullName(String fullName){
            this.fullName = fullName;
            return this;
        }

        public AdminBuilder email(String email){
            this.email = email;
            return this;
        }

        public AdminBuilder password(String password){
            this.password = password;
            return this;
        }

        public AdminBuilder adminName(String adminName){
            this.adminName = adminName;
            return this;
        }

        public AdminBuilder adminPassword(String adminPassword) {
            this.adminPassword = adminPassword;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }

    //Setters
//    public void setId(int id) {
//        this.id = id;
//    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    //Getters
//    public int getId() {
//        return id;
//    }
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
