package lk.sliit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class LoginServiceApplication {

	private static User sarath = new User("sarath", "sarath123");
	private static User ajith = new User("ajith", "ajith123");

	public static HashMap<String, User> users = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);

		users.put(sarath.getUsername(), sarath);
		users.put(ajith.getUsername(), ajith);
	}
}
