package lk.sliit;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class TheatreServiceApplication {

	private static Movie lionKing = new Movie("Lion King", "Epic","2017-06-01","2017-07-09",1994);
	private static Movie theIncredibles = new Movie("The Incredibles", "Action","2017-07-01","2017-08-19",2004);
	private static Movie frozen = new Movie("Frozen", "Action","2017-08-01","2017-08-30",2013);
	private static Movie toyStory = new Movie("Toy Story", "Action","2017-10-11","2017-11-30",1995);

	private static Theatre newCinema = new Theatre("New Cinema", "Kurunegala", 250, "0776787654", new String[]{"10:20:00, 13:30:00, 17:30"}, 300, 30);
	private static Theatre newFreedom = new Theatre("New Freedom", "Gampaha", 350, "0772657689", new String[]{"10:20:00, 13:30:00, 17:30"}, 350, 10);
	private static Theatre wonderCinema = new Theatre("Wonder Cinema", "Panadura", 200, "0776787654", new String[]{"10:20:00, 13:30:00, 17:30"}, 400, 30);

	public static HashMap<String, Theatre> theatres = new HashMap<>();



	public static void main(String[] args) {

        theatres.put(newCinema.getTheatreCode(), newCinema);
        theatres.put(newFreedom.getTheatreCode(), newFreedom);
        theatres.put(wonderCinema.getTheatreCode(), wonderCinema);

        Snack popCorn = new Snack("Pop Corn", 200);
        Snack cola = new Snack("Pop Cola", 150);
        Snack whiteSugar = new Snack("Solid Sugar Brix", 100);
        Snack bitBytes = new Snack("Bits & Bytes", 100);


        newCinema.addMovie(lionKing);
        newCinema.addMovie(toyStory);
        newCinema.addMovie(frozen);
        newFreedom.addMovie(theIncredibles);
        newFreedom.addMovie(toyStory);
        wonderCinema.addMovie(toyStory);
        wonderCinema.addMovie(theIncredibles);

	    SpringApplication.run(TheatreServiceApplication.class, args);
	}
}
