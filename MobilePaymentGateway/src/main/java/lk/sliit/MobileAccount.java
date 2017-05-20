package lk.sliit;

/**
 * Created by VMARALA on 5/19/2017.
 */
public class MobileAccount {
    private String mobileNo;
    private int pin;
    private User u;
    private int balance;

    public MobileAccount() {

    }

    public MobileAccount(String mobileNo, int pin, User u, int balance) {
        this.mobileNo = mobileNo;
        this.pin = pin;
        this.u = u;
        this.balance = balance;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean doTransaction(int amount) {
        if (this.balance >= amount) {
            this.balance = this.balance - amount;
            return true;
        } else {
            return false;
        }
    }
}
