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

    
    // input.close();

}

    

