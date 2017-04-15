package database;

/**
 * Created by David Stražovan on 13.06.2016.
 * Class that represents user data.
 */
public class User {
    private String name;

    public User() {

    }

    public User(String name, String APIKey) {
        this.name = name;
        this.APIKey = APIKey;
    }

    public User(String name, String password, String APIKey) {
        this.APIKey = APIKey;
        this.password = password;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", APIKey='" + APIKey + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAPIKey() {
        return APIKey;
    }

    public void setAPIKey(String APIKey) {
        this.APIKey = APIKey;
    }


    private String APIKey;

}
