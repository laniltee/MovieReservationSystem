package lk.sliit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lanil Marasinghe on 5/15/2017.
 */
public class User {

    private String userName;
    private String password;
    private List<Reservation> reservations;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.reservations = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addReservation(Reservation r) {
        reservations.add(r);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
