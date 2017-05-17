package lk.sliit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lanil Marasinghe on 5/15/2017.
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/")
public class MovieService {

    boolean isAuthenticated = false;
    ObjectMapper jsonMapper = new ObjectMapper();

    @RequestMapping(value = "/theatres", method = RequestMethod.GET)
    public List<Theatre> getTheatres() {
        List<Theatre> theatres = new ArrayList<>(TheatreServiceApplication.theatres.values());
        return theatres;
    }

    @RequestMapping(value = "/theatres/{theatreCode}", method = RequestMethod.GET)
    public Theatre getTheatre(@PathVariable String theatreCode) {
        return TheatreServiceApplication.theatres.get(theatreCode);
    }

    @RequestMapping(value = "/theatres/movies/{theatreCode}", method = RequestMethod.GET)
    public List<Movie> getMovies(@PathVariable String theatreCode) {
        return TheatreServiceApplication.theatres.get(theatreCode).getMovieList();
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>(TheatreServiceApplication.allMovies.values());
        return movies;
    }

    @RequestMapping(value = "/movies/{movieCode}", method = RequestMethod.GET)
    public Movie getMovie(@PathVariable String movieCode) {
        return TheatreServiceApplication.allMovies.get(movieCode);
    }

    @RequestMapping(value = "/snacks", method = RequestMethod.GET)
    public List<Snack> getAllSnacks() {
        List<Snack> snacks = new ArrayList<>(TheatreServiceApplication.allSnacks.values());
        return snacks;
    }

    @RequestMapping(value = "/snacks/{snackId}", method = RequestMethod.GET)
    public Snack getSnack(@PathVariable String snackId) {
        return TheatreServiceApplication.allSnacks.get(snackId);
    }

    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
    public User getUser(@PathVariable String username) {
        return TheatreServiceApplication.users.get(username);
    }

    @RequestMapping(value = "/authenticate/{username}", method = RequestMethod.GET)
    public Authenticator resolveLogin(@PathVariable String username) {
        Authenticator a;
        if (TheatreServiceApplication.users.containsKey(username)) {
            a = new Authenticator(true, TheatreServiceApplication.users.get(username));
            isAuthenticated = true;
        } else {
            a = new Authenticator(false, new User(username, null));
        }
        return a;
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.POST)
    public Reservation addReservation(@RequestBody String payload) {
        Reservation r = new Reservation();
        try {
            ReservationDTO rd = jsonMapper.readValue(payload, ReservationDTO.class);
            System.out.println(rd.toString());
            r.setT(TheatreServiceApplication.theatres.get(rd.getTheatre()));
            r.setM(TheatreServiceApplication.allMovies.get(rd.getMovie()));
            r.setSeats(rd.getSeats());
            r.setResSeats(rd.getCafe());
            r.setS(TheatreServiceApplication.allSnacks.get(rd.getSnack()));
            r.setU(TheatreServiceApplication.users.get(rd.getUser()));
            r.setTotal(r.getT().getPrice() * r.getSeats() + r.getS().getSnackPrice());
            System.out.println(r.toString());

//            if (TheatreServiceApplication.userReservations.containsKey(r.getU().getUserName())) {
//                TheatreServiceApplication.userReservations.get(r.getU().getUserName()).add(r);
//            } else {
//                List<Reservation> l = new ArrayList<>();
//                l.add(r);
//                TheatreServiceApplication.userReservations.put(r.getU().getUserName(), l);
//            }

            r.setActivated(true);
            //r.getU().addReservation(r);
        } catch (IOException e) {
            e.printStackTrace();
            r.setActivated(false);
        }
        return r;
    }

    @RequestMapping(value = "/reservations/{username}", method = RequestMethod.GET)
    public List<Reservation> getReservationsByUser(@PathVariable String username) {
        return TheatreServiceApplication.users.get(username).getReservations();
    }
}
