package lk.sliit;

/**
 * Created by VMARALA on 5/17/2017.
 */
public class ReservationDTO {
    private String theatre;
    private String movie;
    private String snack;
    private String user;
    private int seats;
    private int cafe;

    public ReservationDTO() {
    }

    public ReservationDTO(String theatre, String movie, String snack, int seats, int cafe, String username) {
        this.theatre = theatre;
        this.movie = movie;
        this.snack = snack;
        this.seats = seats;
        this.cafe = cafe;
        this.user = username;
    }

    public String getTheatre() {
        return theatre;
    }

    public void setTheatre(String theatre) {
        this.theatre = theatre;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getSnack() {
        return snack;
    }

    public void setSnack(String snack) {
        this.snack = snack;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getCafe() {
        return cafe;
    }

    public void setCafe(int cafe) {
        this.cafe = cafe;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String username) {
        this.user = username;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "theatre='" + theatre + '\'' +
                ", movie='" + movie + '\'' +
                ", snack='" + snack + '\'' +
                ", seats=" + seats +
                ", cafe=" + cafe +
                '}';
    }
}
