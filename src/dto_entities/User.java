package dto_entities;

/**
 *
 * @author Laura
 */
public class User {
    private String userName;
    private String pass;

    public User() {
    }

    public User(String user, String pass) {
        this.userName = user;
        this.pass = pass;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public String getUserName() {
        return userName;
    }

    public String getPass() {
        return pass;
    }

}
