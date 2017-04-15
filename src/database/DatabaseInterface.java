package database;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by David Stražovan on 13.06.2016.
 * Interface that provides methods to work with data in database.
 */
public interface DatabaseInterface extends AutoCloseable {


    boolean insert(User u) throws SQLException;

    User getUser(String name, String password) throws SQLException;

    boolean deleteUser(String name);

    List<User> getAllUsers() throws SQLException;

}
