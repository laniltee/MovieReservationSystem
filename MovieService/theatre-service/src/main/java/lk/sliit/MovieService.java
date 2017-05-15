package lk.sliit;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VMARALA on 5/15/2017.
 */
@RestController
@RequestMapping(value = "/api/")
public class MovieService {

    @RequestMapping(value = "/theatres", method = RequestMethod.GET)
    public List<Theatre> getTheatres(){
        List<Theatre> theatres = new ArrayList<>(TheatreServiceApplication.theatres.values());
        return theatres;
    }

    @RequestMapping(value = "/theatres/{theatreCode}", method = RequestMethod.GET)
    public Theatre getTheatre(@PathVariable String theatreCode){
        return TheatreServiceApplication.theatres.get(theatreCode);
    }

    @RequestMapping(value = "/movies/{theatreCode}", method = RequestMethod.GET)
    public List<Movie> getMovies(@PathVariable String theatreCode){
        return TheatreServiceApplication.theatres.get(theatreCode).getMovieList();
    }
}
