public class Series {

    private String name;
    private int releaseYear;
    private String genre;
    private int seasons;
    private double rating;

    public Series(String name, int releaseYear, String genre, int seasons, double rating) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.seasons = seasons;
        this.rating = rating;
    }

    public Series(String name) {
        this(name, 0, "", 0, 0);
    }

    public Series(String name, int releaseYear) {
        this(name, releaseYear, "", 0, 0);
    }

    public Series(String name, int releaseYear, String genre) {
        this(name, releaseYear, genre, 0, 0);
    }

    public Series(String name, int releaseYear, String genre, int seasons) {
        this(name, releaseYear, genre, seasons, 0);
    }

    public void addReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void addGenre(String genre) {
        this.genre = genre;
    }

    public void addSeasons(int seasons) {
        this.seasons = seasons;
    }
    
    public void addRating(double rating){
        this.rating = rating;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        if (this.releaseYear != 0) {
            print.append("\nRelease year: ").append(this.releaseYear);
        }
        if (this.seasons != 0) {
            print.append("\nSeasons: ").append(this.seasons);
        }

        if (!this.genre.isEmpty()) {
            print.append("\nGenre: ").append(this.genre);
        }
        if (this.rating != 0) {
            print.append("\nRating: ").append(this.rating).append("/10");
        }

        return "Series title: " + this.name + print + "\n";
    }
}
