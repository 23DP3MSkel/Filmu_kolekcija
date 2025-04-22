import java.util.ArrayList;
import java.util.Scanner;

public class Main {

public static void main(String[] args) {
    User currentUser = null;
    Scanner input = new Scanner(System.in);
    ArrayList<User> users = new ArrayList<>();

    while (true){
        if (currentUser == null){

            System.out.println("Type your username: ");
            String login = input.nextLine();
            for (User something: users){
                if (something.getUsername().equals(login)){
                    currentUser = something;
                    break;
                }
            }
            if (currentUser == null){
                currentUser = new User(login);
                users.add(currentUser);
            }
    }


    // Movies movie;
    // Collection mediaCollection = new Collection();
    System.out.println("Welcome!\nType in your command:");
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

        currentUser.getCollection().addMovie(movie);
        // mediaCollection.addMovie(movie);
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

        // mediaCollection.addSeries(series);
        currentUser.getCollection().addSeries(series);
    }

    // if (user.equals("seeAll")){
    //     System.out.println("Movies: \n");
    //     for (Movies movie : mediaCollection.getMovies()) {
    //         System.out.println(movie+"\n");
    //     }
    //     System.out.println("Series: \n");
    //     for (Series series : mediaCollection.getSeries()) {
    //         System.out.println(series+"\n");
    //     }
    // }
    
    if (user.equals("seeList")){
        System.out.println("Movies: \n");
        for (Movies movie : currentUser.getCollection().getMovies()) {
            System.out.println(movie+"\n");
        }
        System.out.println("Series: \n");
        for (Series series : currentUser.getCollection().getSeries()) {
            System.out.println(series+"\n");
        }
    }


    if(user.equals("exit")){
        break;
    }
    if(user.equals("username")){
        System.out.println(currentUser.getUsername());
    }
    if(user.equals("logout")){
        currentUser = null;
    }

    if(user.equals("help")){

    System.out.println("\nAll commands:\n ~addMovie~ is to add movie to the list;\n ~addSeries~ to add TV series to list;\n ~seeList~ to access your list;\n ~username~ to see current user;\n ~logout~ to log out of current user;\n ~exit~ to end the program;\n ");
}

    continue;


}


}
}
    

