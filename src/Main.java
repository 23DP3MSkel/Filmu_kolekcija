import java.util.Scanner;

public class Main {

public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    // Movies movie;
    Collection mediaCollection = new Collection();
while (true){
    String user = input.nextLine();
    
    if (user.equals("addMovie")){
        System.out.println("Enter movie title");
        Movies movie = new Movies(input.nextLine());
        System.out.println("Add release year: ");
        movie.addYear(Integer.valueOf(input.nextLine()));
        System.out.println("Add genre: ");
        movie.addGenre(input.nextLine());
        System.out.println("Add length: ");
        movie.addLength(Integer.valueOf(input.nextLine()));
        System.out.println("Add rating: ");
        movie.addRating(Double.valueOf(input.nextLine()));

        mediaCollection.addMovie(movie);
    }

    if (user.equals("seeAll")){
        System.out.println(mediaCollection.getMovies());
    }

    if(user.equals("exit")){
        break;
    }

    if(user.equals("help")){

    System.out.println("All commands:\n addMovie ; addSerie ; seeAll ; exit ");
}

    continue;


}


    
    
}
    
}
