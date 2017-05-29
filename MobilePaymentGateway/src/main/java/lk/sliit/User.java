package lk.sliit;

/**
 * Created by Lanil Marasinghe on 5/19/2017.
 */
public class User {
    private String username;
    private String password;
    private int pin;

    public User(String username, String password, int pin) {
        this.username = username;
        this.password = password;
        this.pin = pin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
