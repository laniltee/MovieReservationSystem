package lk.sliit;

/**
 * Created by VMARALA on 5/15/2017.
 */
public class Movie {

    private String movieName;
    private String genre;
    private String startDate;
    private String endDate;
    private int year;

    public Movie(String movieName, String genre, String startDate, String endDate, int year) {
        this.movieName = movieName;
        this.genre = genre;
        this.startDate = startDate;
        this.endDate = endDate;
        this.year = year;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", genre='" + genre + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
