package database;

/**
 * Created by David Stražovan on 13.06.2016.
 * Class that provides sql queries.
 */
public class SQLCommands {
    public static final String CREATE_TABLE =
            "CREATE TABLE USERS(" +
                    // "ID     INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,"+
                    "USERNAME   VARCHAR(100)," +
                    "PASSWORD   VARCHAR(100)," +
                    "APIKEY     VARCHAR(255)," +
                    "PRIMARY KEY(USERNAME))";

    public static final String GET_BY_USERNAME =
            "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";

    public static final String INSERT_USER =
            "INSERT INTO USERS(USERNAME, PASSWORD, APIKEY) VALUES( ?, ?, ?)";

    public static final String GET_ALL =
            "SELECT * FROM USERS";
}
