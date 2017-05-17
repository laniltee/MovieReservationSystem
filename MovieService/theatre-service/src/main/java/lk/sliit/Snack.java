package lk.sliit;

/**
 * Created by VMARALA on 5/15/2017.
 */
public class Snack {

    private String snackName;
    private int snackPrice;
    private String snackCode;

    public Snack(String snackName, int snackPrice) {
        this.snackName = snackName;
        this.snackPrice = snackPrice;
        this.snackCode = "SN_" + this.snackName.substring(0,5).replace(" ", "");
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

    public String getSnackCode() {
        return snackCode;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "snackName='" + snackName + '\'' +
                ", snackPrice=" + snackPrice +
                '}';
    }
}
