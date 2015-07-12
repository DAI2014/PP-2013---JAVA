package pg;

import java.io.Serializable;

public class Administrador implements Serializable{

    private String userName;
    private String password;

    public Administrador(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
        public String toString() {
        StringBuilder novaString = new StringBuilder();
        novaString.append("---------Administrador------------\n");
        novaString.append("   Username: " + getUserName() + "\n");
        novaString.append("   Password: " + getPassword() + "\n");
        novaString.append("----------------------------------");
        return novaString.toString();
    }
}