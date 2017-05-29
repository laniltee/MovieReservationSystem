package lk.sliit;

/**
 * Created by Lanil Marasinghe on 5/19/2017.
 */
public class PaymentRequest {
    private String username;
    private int pin;
    private String mobileNo;
    private int amount;

    public PaymentRequest(){

    }

    public PaymentRequest(String username, int pin, String mobileNo, int amount) {
        this.username = username;
        this.pin = pin;
        this.mobileNo = mobileNo;
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
