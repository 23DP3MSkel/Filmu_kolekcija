import java.io.Serializable;

public class User implements Serializable{

    private String username;
    private Collection list;


    public User(String username){
        this.username = username;
        this.list = new Collection();
    }

    public String getUsername(){
        return this.username;
    }

    public Collection getCollection(){
        return this.list;
    }
    
}
