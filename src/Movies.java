package src;
public class Movies {


private String movieName;
private int releaseYear;
private String genre;
private int length;
private double rating;



public Movies(String movieName){
    this.movieName = movieName;
}


public Movies(String movieName, int releaseYear){
    this.movieName = movieName;
    this.releaseYear = releaseYear;
}

public Movies(String movieName, int releaseYear, String genre){
    this.movieName = movieName;
    this.releaseYear = releaseYear;
    this.genre = genre;

}

public Movies(String movieName, int releaseYear, String genre, int length){
    this.movieName = movieName;
    this.releaseYear = releaseYear;
    this.genre = genre;
    this.length = length;  
}

public Movies(String movieName, int releaseYear, String genre, int length, double rating){
    this.movieName = movieName;
    this.releaseYear = releaseYear;
    this.genre = genre;
    this.length = length;
    this.rating = rating;
}

public void addYear(int releaseYear){
    this.releaseYear = releaseYear;
}


public String toString(){
    // return "Movie title: "+ this.movieName +"\nRelease year: " 
    // + this.releaseYear + "\nMovie genre: " + this.genre 
    // + "\nLength: " + this.length + " min\nRating: "+ this.rating;

    StringBuilder print = new StringBuilder();
    if (this.releaseYear != 0){
        print.append("\nRelease year: ").append(this.releaseYear);
    }
    if (this.genre.isEmpty()){
        
        print.append("\nMovie genre: ").append(this.genre);
    }
    if (this.length != 0){
        print.append("\nLength: ").append(this.length).append(" min");
    }
    if (this.rating != 0){
        print.append("\nRating: ").append(this.rating);
    }


    return "Movie title: "+ this.movieName + print;
}
}
