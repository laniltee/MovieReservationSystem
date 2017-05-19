package lk.sliit;

/**
 * Created by Lanil Marasinghe on 5/18/2017.
 */
public class BankAccount {
    private int accountNo;
    private AccountHolder holder;
    private int balance;

    public BankAccount(int accountNo, AccountHolder holder, int balance) {
        this.accountNo = accountNo;
        this.holder = holder;
        this.balance = balance;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public AccountHolder getHolder() {
        return holder;
    }

    public void setHolder(AccountHolder holder) {
        this.holder = holder;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean creditAccount(int amount) {
        if (this.balance >= amount) {
            this.balance = this.balance - amount;
            return true;
        } else {
            return false;
        }
    }
}
