import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

public static void main(String[] args) {
    User currentUser = null;
    Scanner input = new Scanner(System.in);

    while (true){
        
        if (currentUser == null){

            System.out.println("Type your username: ");
            String login = input.nextLine();
            // String login = "mark";
            if(login.equals("exit")){
                break;
            }
            File userfile = new File("users/"+login+".dat");

            if (userfile.exists()){

                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(userfile))){
                    currentUser = (User) ois.readObject();
                    System.out.println("Welcome back, "+currentUser.getUsername());
                }catch (Exception i){
                    i.printStackTrace();
                }
            }else{
                currentUser = new User(login);
                try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(userfile))){
                    oos.writeObject(currentUser);
                    System.out.println("Welcome, new user!");
                } catch (IOException i){
                    i.printStackTrace();
                }
            }

            
            
    }


    // Movies movie;
    // Collection mediaCollection = new Collection();
    System.out.println("Type in your command:");
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
        save(currentUser);
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
        save(currentUser);
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




    // https://www.baeldung.com/java-printstream-printf
//     The conversion-character is required and determines how the argument is formatted.

// Conversion characters are only valid for certain data types. Here are some common ones:

// s formats strings.
// d formats decimal integers.
// f formats floating-point numbers.
// t formats date/time values.

// https://www.youtube.com/watch?v=Kfc6p41-Iq8




    if (user.equals("movie table")){
        System.out.println();
        System.out.printf("%-20s %-6s %-10s %-8s %-8s%n", "Title", "Year", "Genre", "Length","Rating");
System.out.println("-----------------------------------------------------------");
for (Movies movie : currentUser.getCollection().getMovies()) {
    System.out.printf("%-20s %-6d %-10s %-8d %-8.1f%n",
        movie.getTitle(), movie.getYear(), movie.getGenre(), movie.getLength(),movie.getRating());
}
    }


if (user.equals("series")){
    System.out.println();
    System.out.printf("| %-20s | | %-6s | | %-10s | | %-8s | | %-8s |%n", "Title", "Year", "Genre", "Seasons","Rating");
System.out.println("----------------------------------------------------------------------------");
for (Series serie : currentUser.getCollection().getSeries()) {
System.out.printf("| %-20s | | %-6d | | %-10s | | %-8d | | %-8.1f |%n",
    serie.getTitle(), serie.getYear(), serie.getGenre(), serie.getSeasons(),serie.getRating());
}
System.out.println();



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

    if(user.equals("delete")){
        String username = currentUser.getUsername();
        currentUser = null;
        delete(username);
    }

    if(user.equals("remove movie")){
        Movies delete = null;
        int y = 1;
        
        System.out.println("Choose which movie to remove:");
        for(Movies movie : currentUser.getCollection().getMovies()){
            System.out.println(y+". "+ movie.getTitle());
            y++;
        }
        int i = Integer.valueOf(input.nextLine());
        y = 1;

        for(Movies movie : currentUser.getCollection().getMovies()){
            if (y == i){
                delete = movie;
            }
            y++;
        }
        if(delete != null){
            System.out.println(delete.getTitle() +" has been removed\n");
            currentUser.getCollection().removeMovie(delete);
            save(currentUser);
        }else{
            System.out.println("something went wrong... try again!");
            
        }
        
       
    }

    if(user.equals("help")){

    System.out.println("\nAll commands:\n ~addMovie~ is to add movie to the list;\n ~addSeries~ to add TV series to list;\n ~seeList~ to access your list;\n ~username~ to see current user;\n ~logout~ to log out of current user;\n ~exit~ to end the program;\n ");
}

    continue;


}
    }






private static void save(User currentUser){
    File userFile = new File("users/"+currentUser.getUsername()+".dat");
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(userFile))){
        oos.writeObject(currentUser);
        System.out.println("Saved!");
    }catch(IOException wtv){
        wtv.printStackTrace();
    }

}



private static void delete(String username){
    File file = new File("users/"+username+".dat");
    // Scanner input = new Scanner(System.in);
    // System.out.println("Are you sure? (Type YES)");
    // String confirm = input.nextLine();
    // if (confirm.equals("Yes") || (confirm.equals("yes")) || confirm.equals("YES")){
        if(file.delete()){
            System.out.println("User "+username+" has been deleted");
        }
        else{
            System.out.println("Something went wrong...");
        }
    }



    
    
}

    

