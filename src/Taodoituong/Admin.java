package Taodoituong;

import java.io.Serializable;

public class Admin extends Account implements Serializable {
    public Admin() {
        this.setRole("Admin");
    }

    public Admin(String username, String password) {
        super(username, password);
        this.setRole("Admin");
    }
}

