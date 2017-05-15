package lk.sliit;

import java.util.Arrays;

/**
 * Created by VMARALA on 5/15/2017.
 */
public class Theatre {

    private String theatreName;
    private String theatreLocation;
    private int seatsCount;
    private String contactNo;
    private String[] showTimes;
    private int price;
    private int restaurantSeats;

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
