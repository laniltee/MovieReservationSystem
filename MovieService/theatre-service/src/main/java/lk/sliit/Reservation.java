package lk.sliit;

import javax.jws.soap.SOAPBinding;

/**
 * Created by VMARALA on 5/16/2017.
 */
public class Reservation {
    private String id;
    private Theatre t;
    private Movie m;
    private User u;
    private int seats;
    private Snack s;
    private int resSeats;
    private int total;
    private boolean activated;

    public Reservation(){
        this.id = "RES" + ServiceUtility.getRandomNumber();
    }

    public Reservation(Theatre t, User u, Movie m, int seats, Snack s, int resSeats) {
        this.id = "RES" + ServiceUtility.getRandomNumber();
        this.m = m;
        this.t = t;
        this.u = u;
        this.seats = seats;
        this.s = s;
        this.resSeats = resSeats;
        this.total = 0;
    }

    public String getId() {
        return id;
    }

    public Theatre getT() {
        return t;
    }

    public void setT(Theatre t) {
        this.t = t;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Snack getS() {
        return s;
    }

    public void setS(Snack s) {
        this.s = s;
    }

    public int getResSeats() {
        return resSeats;
    }

    public void setResSeats(int resSeats) {
        this.resSeats = resSeats;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Movie getM() {
        return m;
    }

    public void setM(Movie m) {
        this.m = m;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", t=" + t +
                ", m=" + m +
                ", u=" + u +
                ", seats=" + seats +
                ", s=" + s +
                ", resSeats=" + resSeats +
                ", total=" + total +
                ", activated=" + activated +
                '}';
    }
}
