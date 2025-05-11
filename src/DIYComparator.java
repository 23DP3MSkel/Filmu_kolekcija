import java.util.Comparator;

public class DIYComparator {


        public static final Comparator<Movies> MByTitle = new Comparator<Movies>() {
            
            public int compare(Movies m1, Movies m2){
                return m1.getTitle().compareToIgnoreCase(m2.getTitle());
            }
        };

        public static final Comparator<Movies> MByRating = new Comparator<Movies>() {
            
            public int compare(Movies m1, Movies m2){
                if(m1.getRating()>m2.getRating())
                    return 1;
                if(m1.getRating()==m2.getRating())
                    return 0;
                else 
                    return -1;
                
            }
        };
        public static final Comparator<Movies> MByYear = new Comparator<Movies>() {
            
            public int compare(Movies m1, Movies m2){
                if(m1.getYear()>m2.getYear())
                    return 1;
                if(m1.getYear()==m2.getYear())
                    return 0;
                else 
                    return -1;
                
            }
        };
        
        public static final Comparator<Series> SByTitle = new Comparator<Series>() {
            
            public int compare(Series m1, Series m2){
                return m1.getTitle().compareTo(m2.getTitle());
            }
        };
        
        public static final Comparator<Series> SByRating = new Comparator<Series>() {
            
            public int compare(Series m1, Series m2){
                return m1.getTitle().compareTo(m2.getTitle());
            }
        };  
        public static final Comparator<Series> SByYear = new Comparator<Series>() {
            
            public int compare(Series m1, Series m2){
                if(m1.getYear()>m2.getYear())
                    return 1;
                if(m1.getYear()==m2.getYear())
                    return 0;
                else 
                    return -1;
                
            }
        };      

        

    }


