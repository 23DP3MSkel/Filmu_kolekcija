public class Test {


    public static void main(String[] args) {
        testMovie();
        testSeries();
        testUser();
        testCollection();
        testComparator();
    }


    public static void testMovie(){
        System.out.println("Movie testing:\n");

        Movies movie = new Movies("Barbie",2023,"Fantasy",128);
        movie.addRating(8.2);
        if(movie.getTitle().equalsIgnoreCase("Barbie")){
            System.out.println("Title success ");
        }else{
            System.out.println("Title failed");
        }

        if(movie.getYear() == 2023){
            System.out.println("Year success");
        }else{
            System.out.println("Year failed");
        }

        if(movie.getGenre().equals("Fantasy")){
            System.out.println("Genre success");
        }else{
            System.out.println("Genre failed");
        }

        if(movie.getRating() == 8.2){
            System.out.println("Rating was added succesfully");
        }else{
            System.out.println("Rating failed");
        }
    }


    public static void testSeries(){
        System.out.println("\n\nSeries testing:\n");

        Series serie = new Series("WandaVision",2021,"Fantasy");
        serie.addSeasons(1);
        serie.addRating(7.9);

        if(serie.getTitle().equalsIgnoreCase("Wandavision")){
            System.out.println("Title success ");
        }else{
            System.out.println("Title failed");
        }

        if(serie.getYear() == 2021){
            System.out.println("Year success");
        }else{
            System.out.println("Year failed");
        }

        if(serie.getRating() == 7.9){
            System.out.println("Rating added success");
        }else{
            System.out.println("Rating failed");
        }

        if(serie.getSeasons() == 1){
            System.out.println("Seasons were added successfully");
        }else{
            System.out.println("Seasons failed");
        }
        
    }


    public static void testUser(){
        System.out.println("\nTesting User class");
        User user = new User("Wanda");
        if(user.getUsername().equalsIgnoreCase("wanda")){
            System.out.println("Username correct");
        }else{
            System.out.println("Username failed");
        }
    }

    public static void testCollection(){

        System.out.println("\nTesting Collection\n");

        Collection list = new Collection();
        list.addMovie(new Movies("Barbie",2023,"Fantasy",128,8.2));
        list.addSeries(new Series("WandaVision",2021,"Fantasy",1,7.9));
        Series show = new Series("Something",2015);
        list.addSeries(show);

        if(list.getMovies().size() == 1){
            System.out.println("Movie adding was successfull");
        }else{
            System.out.println("Movie adding was failed");
        }
        if(list.getSeries().size()==2){
            System.out.println("Series adding was successfull");

        }else{
            System.out.println("Series adding failed");
        }
        
    }

    public static void testComparator(){
        System.out.println("\nTesting DIYComparator\n");
        Movies movie1 = new Movies("Avengers",2019,"Fantasy",210, 9.1);
        Movies movie2 = new Movies("Barbie",2023,"Fantasy",145,8.2);
        Movies movie3 = new Movies("Avengers");

        if(DIYComparator.MByTitle.compare(movie1, movie2) < 0 ){
            System.out.println("Movie title comparator works");
        }else{
            System.out.println("Movie title comparator failed");
        }

        if(DIYComparator.MByRating.compare(movie1, movie2) > 0){
            System.out.println("Movie rating comparator works");
        }else{
            System.out.println("Movie rating comparator failed");
        }

        if(DIYComparator.MByTitle.compare(movie1, movie3) == 0){
            System.out.println("Same movie title comparator works");
        }else{
            System.out.println("Same movie title comparato FAILED");
        }
        

        Series show1 = new Series("wandavision", 2021);
        Series show2 = new Series("Gossip girl",2007);
        Series show3 = new Series("something",2021);

        if(DIYComparator.SByTitle.compare(show1, show2) > 0){
            System.out.println("Series title comparator works");
        }else{
            System.out.println("Series title comparator failed");
        }

        if(DIYComparator.SByYear.compare(show1, show2) >0){
            System.out.println("Series year comparator works");
        }else{
            System.out.println("Series year comparator failed");
        }

        if(DIYComparator.SByYear.compare(show1, show3) == 0){
            System.out.println("Series same year comparator works");
        }else{
            System.out.println("Series same year comparator failed");
        }




    }

}
