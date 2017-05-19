package lk.sliit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class PaymentGatewayApplication {

    private static AccountHolder u1 = new AccountHolder("J.K.Jayarathne", "jkjaye", "123");
    private static AccountHolder u2 = new AccountHolder("J.A.Ariyapala", "ajith", "123");
    private static AccountHolder u3 = new AccountHolder("A.S.Angampitiya", "sarath", "123");

    private static BankAccount b1 = new BankAccount(766545, u2, 2000);
    private static BankAccount b2 = new BankAccount(758392, u3,5600);

    private static CreditCard c1 = new CreditCard("4024007116422816", 675, b1);
    private static CreditCard c2 = new CreditCard("4716415469682337", 456, b2);

    protected static HashMap<String, CreditCard> cards = new HashMap<>();
    protected static HashMap<String, AccountHolder> customers = new HashMap<>();


    public static void main(String[] args) {

        cards.put(c1.getCardNo(), c1);
        cards.put(c2.getCardNo(), c2);

        customers.put(u2.getUsername(), u2);
        customers.put(u3.getUsername(), u3);

        SpringApplication.run(PaymentGatewayApplication.class, args);
    }
}
