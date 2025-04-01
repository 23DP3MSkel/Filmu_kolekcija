package src;

public class Series {

    private String name;
    private int releaseYear;
    private int seasons;
    private int episodes;
    private String genre;
    private double rating;
    private String description;

    public Series(String name, int releaseYear, int seasons, int episodes, String genre, double rating, String description) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.seasons = seasons;
        this.episodes = episodes;
        this.genre = genre;
        this.rating = rating;
        this.description = description;
    }

    public Series(String name) {
        this(name, 0, 0, 0, "", 0, "");
    }

    public Series(String name, int releaseYear) {
        this(name, releaseYear, 0, 0, "", 0, "");
    }

    public Series(String name, int releaseYear, int seasons) {
        this(name, releaseYear, seasons, 0, "", 0, "");
    }

    public Series(String name, int releaseYear, int seasons, int episodes) {
        this(name, releaseYear, seasons, episodes, "", 0, "");
    }

    public Series(String name, int releaseYear, int seasons, int episodes, String genre) {
        this(name, releaseYear, seasons, episodes, genre, 0, "");
    }

    public Series(String name, int releaseYear, int seasons, int episodes, String genre, double rating) {
        this(name, releaseYear, seasons, episodes, genre, rating, "");
    }

    public void addReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void addSeasons(int seasons) {
        this.seasons = seasons;
    }

    public void addEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public void addGenre(String genre) {
        this.genre = genre;
    }
    
    public void addRating(double rating){
        this.rating = rating;
    }
    public void addDescription(String description){
        this.description = description;
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
        if (this.episodes != 0) {
            print.append("\nEpisodes: ").append(this.episodes);
        }
        if (!this.genre.isEmpty()) {
            print.append("\nGenre: ").append(this.genre);
        }
        if (this.rating != 0) {
            print.append("\nRating: ").append(this.rating).append("/10");
        }
        if (!this.description.isEmpty()) {
            print.append("\nDescription: ").append(this.description);
        }

        return "Series title: " + this.name + print + "\n";
    }
}
