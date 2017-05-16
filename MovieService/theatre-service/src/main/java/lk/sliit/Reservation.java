package lk.sliit;

import javax.jws.soap.SOAPBinding;

/**
 * Created by VMARALA on 5/16/2017.
 */
public class Reservation {
    private int id;
    private Theatre t;
    private User u;
    private int seats;
    private Snack s;
    private int resSeats;

    public Reservation(int id, Theatre t, User u, int seats, Snack s, int resSeats) {
        this.id = id;
        this.t = t;
        this.u = u;
        this.seats = seats;
        this.s = s;
        this.resSeats = resSeats;
    }
}
