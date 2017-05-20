package lk.sliit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class MobilePayGatewayApplication {

    private static User u1 = new User("ajith", "ajith123", 1234);
    private static User u2 = new User("sarath", "sarath123", 1234);

    private static MobileAccount m1 = new MobileAccount("778767567", 1234, u1, 23000);
    private static MobileAccount m2 = new MobileAccount("776545345", 1234, u2, 5000);

    protected static HashMap<String, User> users = new HashMap<>();
    protected static HashMap<String, MobileAccount> accounts = new HashMap<>();

    public static void main(String[] args) {
        users.put(u1.getUsername(), u1);
        users.put(u2.getUsername(), u1);

        accounts.put(m1.getMobileNo(), m1);
        accounts.put(m2.getMobileNo(), m2);

        SpringApplication.run(MobilePayGatewayApplication.class, args);
    }
}
