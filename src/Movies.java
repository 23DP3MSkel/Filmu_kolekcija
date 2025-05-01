import java.io.Serializable;

public class Movies implements Serializable {


private String movieName;
private int releaseYear;
private String genre;
private int length;
private double rating;



public Movies(String movieName, int releaseYear, String genre, int length, double rating){
    this.movieName = movieName;
    this.releaseYear = releaseYear;
    this.genre = genre;
    this.length = length;
    this.rating = rating;
}

public Movies(String movieName){
    this(movieName, 0,"",0,0);
}

public Movies(String movieName, int releaseYear){
    this(movieName, releaseYear,"",0,0);
}

public Movies(String movieName, int releaseYear, String genre){
    this(movieName, releaseYear,genre,0,0);
}

public Movies(String movieName, int releaseYear, String genre, int length){
    this(movieName, releaseYear,genre,length,0);
}


public void addYear(int releaseYear){
    this.releaseYear = releaseYear;
}

public void addGenre(String genre){
    this.genre = genre;
}


public void addLength(int length){
    this.length = length;
}

public void addRating(double rating){
    this.rating = rating;
}
public String getTitle(){
    return this.movieName;
}
public int getYear(){
    return this.releaseYear;
}

public String getGenre(){
    return this.genre;
}
public int getLength(){
    return this.length;
}
public double getRating(){
    return this.rating;
}





@Override
public String toString(){
    // return "Movie title: "+ this.movieName +"\nRelease year: " 
    // + this.releaseYear + "\nMovie genre: " + this.genre 
    // + "\nLength: " + this.length + " min\nRating: "+ this.rating;

    StringBuilder print = new StringBuilder();
    if (this.releaseYear != 0){
        print.append("\nRelease year: ").append(this.releaseYear);
    }
    if (this.genre != ""){
        
        print.append("\nMovie genre: ").append(this.genre);
    }
    if (this.length != 0){
        print.append("\nLength: ").append(this.length).append(" min");
    }
    if (this.rating != 0){
        print.append("\nRating: ").append(this.rating).append("/10");
    }


    return "Movie title: "+ this.movieName + print + "\n";
}
}
