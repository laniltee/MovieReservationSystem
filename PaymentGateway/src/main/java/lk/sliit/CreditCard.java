package lk.sliit;

/**
 * Created by Lanil Marasinghe on 5/18/2017.
 */
public class CreditCard {
    private String cardNo;
    private int cvc;
    private BankAccount account;

    public CreditCard(String cardNo, int cvc, BankAccount account) {
        this.cardNo = cardNo;
        this.cvc = cvc;
        this.account = account;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public boolean addPayment(int amount){
        return this.account.creditAccount(amount);
    }
}
