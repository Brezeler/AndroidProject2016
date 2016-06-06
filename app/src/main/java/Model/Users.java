package Model;

/**
 * Created by Brezeler on 06/06/2016.
 */
public class Users {

    private String email;
    private String password;
    private String name;
    private  String firstname;

    public Users(String email, String password, String name, String firstname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
