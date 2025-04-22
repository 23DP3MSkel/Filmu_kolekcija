import java.util.Scanner;

public class Main {

public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    // Movies movie;
    Collection mediaCollection = new Collection();
while (true){
    System.out.println("Type in your command");
    String user = input.nextLine();
    
    
    if (user.equals("addMovie") || user.equals("addmovie")){
        System.out.println("Enter movie title");
        Movies movie = new Movies(input.nextLine());
        System.out.println("Add release year: ");
            String number = input.nextLine();
            if (!number.isEmpty()){
                movie.addYear(Integer.valueOf(number));
            }
        System.out.println("Add genre: ");
        movie.addGenre(input.nextLine());
        System.out.println("Add length: ");
            number = input.nextLine();
            if (!number.isEmpty()){
                movie.addLength(Integer.valueOf(number));
            }

        System.out.println("Add rating: ");
            number = input.nextLine();
            if (!number.isEmpty()){
                movie.addRating(Double.valueOf(number));
            }

        mediaCollection.addMovie(movie);
    }


    if (user.equals("addSeries")){
        System.out.println("Enter series title");
        Series series = new Series(input.nextLine());
        System.out.println("Add release year: ");
            String number = input.nextLine();
            if (!number.isEmpty()){
                series.addReleaseYear(Integer.valueOf(number));
            }
        System.out.println("Add genre: ");
        series.addGenre(input.nextLine());
        System.out.println("Add seasons: ");
            number = input.nextLine();
            if (!number.isEmpty()){
                series.addSeasons(Integer.valueOf(number));
            }

        System.out.println("Add rating: ");
            number = input.nextLine();
            if (!number.isEmpty()){
                series.addRating(Double.valueOf(number));
            }

        mediaCollection.addSeries(series);
    }

    if (user.equals("seeAll")){
        for (Movies movie : mediaCollection.getMovies()) {
            System.out.println(movie);
        }
    }
    

    if(user.equals("exit")){
        break;
    }

    if(user.equals("help")){

    System.out.println("All commands:\n addMovie ; addSeries ; seeAll ; exit ");
}

    continue;


}


    
    
}
    
}
