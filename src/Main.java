import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

public static void main(String[] args) {
    User currentUser = null;
    Scanner input = new Scanner(System.in);
    File folder = new File("UsrInfo");
    if(!folder.exists()){
        folder.mkdir();
    }

    while (true){
        
        
        if (currentUser == null){

            System.out.println("Type your username: ");
            String login = input.nextLine();
            // String login = "mark";
            if(login.equalsIgnoreCase("exit")){
                break;
            }
            File userfile = new File("UsrInfo/"+login+".dat");

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
    
    
    if (user.equalsIgnoreCase("addMovie") || user.equalsIgnoreCase("add movie")){
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


    if (user.equalsIgnoreCase("addSeries") || user.equalsIgnoreCase("Add series")){
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

    // if (user.equalsIgnoreCase("seeAll")){
    //     System.out.println("Movies: \n");
    //     for (Movies movie : mediaCollection.getMovies()) {
    //         System.out.println(movie+"\n");
    //     }
    //     System.out.println("Series: \n");
    //     for (Series series : mediaCollection.getSeries()) {
    //         System.out.println(series+"\n");
    //     }
    // }
    
    if (user.equalsIgnoreCase("seeList")){
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





if (user.equalsIgnoreCase("movie table")){
    printMovieTable(currentUser);
}

if (user.equalsIgnoreCase("sort movies")){
    System.out.println("Would you like to sort by: \n\nTitle (A-Z) - 1\nTitle (Z-A) - 2\n\nYear - 3 (ASC)\nYear - 4 (DSC)\n\nRating (ASC) - 5\nRating (DSC) - 6");
    String choice = input.nextLine();
    if(Integer.valueOf(choice) == 1){
        Collections.sort(currentUser.getCollection().getMovies(), DIYComparator.MByTitle);
    }
    if(Integer.valueOf(choice) == 2){
        Collections.sort(currentUser.getCollection().getMovies(), DIYComparator.MByTitle.reversed());
    }
    if(Integer.valueOf(choice) == 3){
        Collections.sort(currentUser.getCollection().getMovies(), DIYComparator.MByYear);
    }
    if(Integer.valueOf(choice) == 4){
        Collections.sort(currentUser.getCollection().getMovies(), DIYComparator.MByYear.reversed());
        }
        if(Integer.valueOf(choice) == 5){
            Collections.sort(currentUser.getCollection().getMovies(), DIYComparator.MByRating);
        }
        if(Integer.valueOf(choice) == 6){
            Collections.sort(currentUser.getCollection().getMovies(), DIYComparator.MByRating.reversed());
        }save(currentUser);
        printMovieTable(currentUser);
        
    }
    
    
    if (user.equalsIgnoreCase("series table")){
        printSeriesTable(currentUser);
    }
    if (user.equalsIgnoreCase("sort series")){
    System.out.println("Would you like to sort by: \n\nTitle (A-Z) - 1\nTitle (Z-A) - 2\n\nYear - 3 (ASC)\nYear - 4 (DSC)\n\nRating (ASC) - 5\nRating (DSC) - 6");
    String choice = input.nextLine();
    if(Integer.valueOf(choice) == 1){
        Collections.sort(currentUser.getCollection().getSeries(), DIYComparator.SByTitle);
    }
    if(Integer.valueOf(choice) == 2){
        Collections.sort(currentUser.getCollection().getSeries(), DIYComparator.SByTitle.reversed());
    }
    if(Integer.valueOf(choice) == 3){
        Collections.sort(currentUser.getCollection().getSeries(), DIYComparator.SByYear);
    }
    if(Integer.valueOf(choice) == 4){
        Collections.sort(currentUser.getCollection().getSeries(), DIYComparator.SByYear.reversed());
        }
        if(Integer.valueOf(choice) == 5){
            Collections.sort(currentUser.getCollection().getSeries(), DIYComparator.SByRating);
        }
        if(Integer.valueOf(choice) == 6){
            Collections.sort(currentUser.getCollection().getSeries(), DIYComparator.SByRating.reversed());
        }save(currentUser);
        printSeriesTable(currentUser);
        
    }
    if(user.equalsIgnoreCase("calculations")){
        System.out.println();
        System.out.println("Movie amount: "+currentUser.getCollection().getMovies().size());
        System.out.println("Series amount: "+ currentUser.getCollection().getSeries().size());
        System.out.println("Movie and series amount together: "+(currentUser.getCollection().getMovies().size()+currentUser.getCollection().getSeries().size()));
        
        double movieLength = 0;
        for(Movies movie:currentUser.getCollection().getMovies()){
            movieLength +=movie.getLength();
        }
        
        if(movieLength != 0){
            System.out.println("Movie average length is: "+movieLength/currentUser.getCollection().getMovies().size());
        }
        System.out.println();
        
    }
    
    
    if (user.equalsIgnoreCase("edit movie")){
        Movies edit = null;
        int y = 1;

        
        System.out.println("Choose which movie to edit:");

        for(Movies movie : currentUser.getCollection().getMovies()){
            if (movie.getYear() == 0){
                System.out.println(y+". "+ movie.getTitle());
            y++;
            }else{
            System.out.println(y+". "+ movie.getTitle()+" "+movie.getYear());
            y++;
            }
        }
        int i = Integer.valueOf(input.nextLine());
        y = 1;
        
        for(Movies movie : currentUser.getCollection().getMovies()){
            if (y == i){
                edit = movie;
            }
            y++;
        }
        if(edit != null){
            System.out.println("The title is '"+ edit.getTitle()+"' enter new title or press enter to keep.");
            String editing = input.nextLine();
            if(!editing.isEmpty()){
                edit.addTitle(editing);
            }
            System.out.println("The release year is '"+ edit.getYear()+"' enter new year or press enter to keep.");
            editing = input.nextLine();
            if(!editing.isEmpty()){
                edit.addYear(Integer.valueOf(editing));
            }
            System.out.println("The genre is '"+ edit.getGenre()+"' enter new genre or press enter to keep.");
            editing = input.nextLine();
            if(!editing.isEmpty()){
                edit.addGenre(editing);
            }
            System.out.println("The length is '"+ edit.getLength()+"' enter new length or press enter to keep.");
            editing = input.nextLine();
            if(!editing.isEmpty()){
                edit.addLength(Integer.valueOf(editing));
            }
            System.out.println("The rating is '"+ edit.getRating()+"' enter new rating or press enter to keep.");
            editing = input.nextLine();
            if(!editing.isEmpty()){
                edit.addRating(Double.valueOf(editing));
            }
            
            save(currentUser);
        }else{
            System.out.println("something went wrong... try again!");
            
        }
        
        
    }
    
    
    
    
    
    if(user.equalsIgnoreCase("exit")){
        break;
    }
    if(user.equalsIgnoreCase("username")){
        System.out.println(currentUser.getUsername());
    }
    if(user.equalsIgnoreCase("logout")){
        currentUser = null;
    }
    
    if(user.equalsIgnoreCase("delete user")){
        System.out.println("Are you sure you'd like to delete user '" + currentUser.getUsername()+"' ?");
        String accept = input.nextLine();
        if (accept.equalsIgnoreCase("yes")){
        String username = currentUser.getUsername();
        currentUser = null;
        delete(username);
        }
    }
    
    if(user.equalsIgnoreCase("remove movie")){
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
    
    if(user.equalsIgnoreCase("search movie")){
        System.out.println("What's the title of movie you'd like to find?");
        String title = input.nextLine();
        searchMovie(currentUser, title);
    }

    if(user.equalsIgnoreCase("search series")){
        System.out.println("What's the title of series you'd like to find?");
        String title = input.nextLine();
        searchSeries(currentUser, title);
    }

    if(user.equalsIgnoreCase("help")){
        
        System.out.println("\nAll commands:\n ~addMovie~ is to add movie to the list;\n ~addSeries~ to add TV series to list;\n ~seeList~ to access your list;\n ~username~ to see current user;\n ~logout~ to log out of current user;\n ~exit~ to end the program;\n ");
    }
    
    continue;
    
    
}
}

// https://www.youtube.com/watch?v=oAp4GYprVHM comparator





private static void save(User currentUser){
    File userFile = new File("UsrInfo/"+currentUser.getUsername()+".dat");
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(userFile))){
        oos.writeObject(currentUser);
        System.out.println("Saved!");
    }catch(IOException wtv){
        wtv.printStackTrace();
    }
    
}



private static void delete(String username){
    File file = new File("UsrInfo/"+username+".dat");
    // Scanner input = new Scanner(System.in);
    // System.out.println("Are you sure? (Type YES)");
    // String confirm = input.nextLine();
    // if (confirm.equalsIgnoreCase( || (confirm.equalsIgnoreCase() || confirm.equalsIgnoreCase("YES")){
        if(file.delete()){
            System.out.println("User '"+username+"' has been deleted");
        }
        else{
            System.out.println("Something went wrong...");
        }
    }
    
    
    
public static void printMovieTable(User currentUser){
    System.out.println();
        System.out.printf("%-20s %-6s %-10s %-8s %-8s%n", "Title", "Year", "Genre", "Length","Rating");
System.out.println("-----------------------------------------------------------");
for (Movies movie : currentUser.getCollection().getMovies()) {
    System.out.printf("%-20s %-6d %-10s %-8d %-8.1f%n",
        movie.getTitle(), movie.getYear(), movie.getGenre(), movie.getLength(),movie.getRating());
    
    }
    
    
}

public static void printSeriesTable(User user){
    System.out.println();
        System.out.printf("| %-20s | | %-6s | | %-10s | | %-8s | | %-8s |%n", "Title", "Year", "Genre", "Seasons","Rating");
        System.out.println("----------------------------------------------------------------------------");
        for (Series serie : user.getCollection().getSeries()) {
            System.out.printf("| %-20s | | %-6d | | %-10s | | %-8d | | %-8.1f |%n",
            serie.getTitle(), serie.getYear(), serie.getGenre(), serie.getSeasons(),serie.getRating());
        }
        System.out.println();
}


public static void searchMovie(User user, String title){
    int a = 0;
    for(Movies movie: user.getCollection().getMovies()){
        if (movie.getTitle().equalsIgnoreCase(title)){
            if(a==0){
                System.out.println("\nFound it : \n");
            }
            System.out.println(movie);
            a = 1;
        }
    }
    if(a==0){
    System.out.println("Sorry, couldn't find it\n");
    }
}


public static void searchSeries(User user, String title){
    int a = 0;
    for(Series serie: user.getCollection().getSeries()){
        if (serie.getTitle().equalsIgnoreCase(title)){
            if(a==0){
                System.out.println("\nFound it : \n");
            }
            System.out.println(serie);
            a = 1;
        }
    }
    if(a==0){
    System.out.println("Sorry, couldn't find it\n");
    }
}


}

    

