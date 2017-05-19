package lk.sliit;

/**
 * Created by VMARALA on 5/18/2017.
 */
public class PriceRequest {
    private String theatreCode;
    private String snackCode;
    private int seats;

    public PriceRequest(String theatreCode, String snackCode, int seats) {
        this.theatreCode = theatreCode;
        this.snackCode = snackCode;
        this.seats = seats;
    }

    public PriceRequest(){

    }

    public String getTheatreCode() {
        return theatreCode;
    }

    public void setTheatreCode(String theatreCode) {
        this.theatreCode = theatreCode;
    }

    public String getSnackCode() {
        return snackCode;
    }

    public void setSnackCode(String snackCode) {
        this.snackCode = snackCode;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
