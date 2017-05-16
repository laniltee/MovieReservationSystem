package lk.sliit;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VMARALA on 5/15/2017.
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/")
public class MovieService {

    boolean isAuthenticated = false;

    @RequestMapping(value = "/theatres", method = RequestMethod.GET)
    public List<Theatre> getTheatres() {
        List<Theatre> theatres = new ArrayList<>(TheatreServiceApplication.theatres.values());
        return theatres;
    }

    @RequestMapping(value = "/theatres/{theatreCode}", method = RequestMethod.GET)
    public Theatre getTheatre(@PathVariable String theatreCode) {
        return TheatreServiceApplication.theatres.get(theatreCode);
    }

    @RequestMapping(value = "/movies/{theatreCode}", method = RequestMethod.GET)
    public List<Movie> getMovies(@PathVariable String theatreCode) {
        return TheatreServiceApplication.theatres.get(theatreCode).getMovieList();
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<Movie> getAllMovies(){
        return TheatreServiceApplication.allMovies;
    }

    @RequestMapping(value = "/snacks", method = RequestMethod.GET)
    public List<Snack> getAllSnacks(){
        return TheatreServiceApplication.allSnacks;
    }

    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
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
}
