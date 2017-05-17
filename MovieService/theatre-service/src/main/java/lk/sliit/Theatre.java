package lk.sliit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by VMARALA on 5/15/2017.
 */
public class Theatre {

    private String theatreName;
    private String theatreCode;
    private String theatreLocation;
    private int seatsCount;
    private String contactNo;
    private String[] showTimes;
    private int price;
    private int restaurantSeats;
    private List<Movie> movieList;

    public Theatre(String theatreName, String theatreLocation, int seatsCount, String contactNo, String[] showTimes, int price, int restaurantSeats) {
        this.theatreName = theatreName;
        this.theatreLocation = theatreLocation;
        this.seatsCount = seatsCount;
        this.contactNo = contactNo;
        this.showTimes = showTimes;
        this.price = price;
        this.restaurantSeats = restaurantSeats;
        movieList = new ArrayList<>();
        this.theatreCode = "TH_" + this.theatreName.substring(0,5).replace(" ", "");
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getTheatreLocation() {
        return theatreLocation;
    }

    public void setTheatreLocation(String theatreLocation) {
        this.theatreLocation = theatreLocation;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(int seatsCount) {
        this.seatsCount = seatsCount;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String[] getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(String[] showTimes) {
        this.showTimes = showTimes;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRestaurantSeats() {
        return restaurantSeats;
    }

    public void setRestaurantSeats(int restaurantSeats) {
        this.restaurantSeats = restaurantSeats;
    }

    public void reserveSeat(){
        this.seatsCount--;
    }

    public void addMovie(Movie m){
        this.movieList.add(m);
    }

    public String getTheatreCode() {
        return theatreCode;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "theatreName='" + theatreName + '\'' +
                ", theatreLocation='" + theatreLocation + '\'' +
                ", seatsCount=" + seatsCount +
                ", contactNo='" + contactNo + '\'' +
                ", showTimes=" + Arrays.toString(showTimes) +
                ", price=" + price +
                ", restaurantSeats=" + restaurantSeats +
                '}';
    }
}
