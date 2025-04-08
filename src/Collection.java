import java.util.ArrayList;

public class Collection {

    private ArrayList<Movies> movies;
    private ArrayList<Series> series;



    public Collection() {
        this.movies = new ArrayList<>();
        this.series = new ArrayList<>();
    }

    public void addMovie(Movies movie) {
        this.movies.add(movie);
    }
    public void addSeries(Series series) {
        this.series.add(series);
    }


    public ArrayList<Movies> getMovies() {
        return movies;
    }
    public ArrayList<Series> getSeries() {
        return series;
    }



    public void removeMovie(Movies movie) {
        this.movies.remove(movie);
    }
    public void removeSeries(Series series) {
        this.series.remove(series);
    }


    
}
