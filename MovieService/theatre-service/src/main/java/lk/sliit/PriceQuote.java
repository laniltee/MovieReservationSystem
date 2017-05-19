package lk.sliit;

/**
 * Created by VMARALA on 5/18/2017.
 */
public class PriceQuote {
    private String user;
    private boolean status;
    private int total;

    public PriceQuote(){

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
