package dto_entities;

/**
 *
 * @author Laura
 */
public class User {
    private int id;
    private String userName;
    private String pass;

    public User() {
    }

    public User(int id, String userName, String pass) {
        this.id = id;
        this.userName = userName;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

}
