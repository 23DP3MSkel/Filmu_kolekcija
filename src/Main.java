package src;

public class Main {

public static void main(String[] args) {
    
    Movies movie1 = new Movies("The Godfather", 1972, "Crime", 175, 9.2);
    Movies movie2 = new Movies("The Dark Knight", 2008, "Action", 152, 9.0);
    
    Series series1 = new Series("Witches of East End", 2013, 2, 23, "Fantasy", 7.6, "Two sisters discover they are witches and must navigate their magical heritage.");
    Series series2 = new Series("WandaVision", 2021, 1, 9, "Superhero", 8.0, "Wanda Maximoff and Vision navigate suburban life while uncovering a larger mystery.");
    System.out.println(movie1);
    System.out.println(movie2);
    
    System.out.println(series1);
    System.out.println(series2);
}
    
}
