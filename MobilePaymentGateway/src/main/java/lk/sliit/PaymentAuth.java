package lk.sliit;

/**
 * Created by VMARALA on 5/18/2017.
 */
public class PaymentAuth {
    private int amount;
    private String mobileNo;
    private String timeStamp;
    private boolean status;
    private String message;
    private String username;

    public PaymentAuth(int amount, String creditCardNo, String timeStamp, boolean status, String message) {
        this.amount = amount;
        this.mobileNo = creditCardNo;
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
    }

    public PaymentAuth(){

    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
