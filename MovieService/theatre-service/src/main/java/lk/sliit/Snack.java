package lk.sliit;

/**
 * Created by VMARALA on 5/15/2017.
 */
public class Snack {

    private String snackName;
    private int snackPrice;

    public Snack(String snackName, int snackPrice) {
        this.snackName = snackName;
        this.snackPrice = snackPrice;
    }

    public void setSnackName(String snackName) {
        this.snackName = snackName;
    }

    public void setSnackPrice(int snackPrice) {
        this.snackPrice = snackPrice;
    }

    public String getSnackName() {
        return snackName;
    }

    public int getSnackPrice() {
        return snackPrice;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "snackName='" + snackName + '\'' +
                ", snackPrice=" + snackPrice +
                '}';
    }
}
