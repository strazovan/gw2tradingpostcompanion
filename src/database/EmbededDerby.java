package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import database.SQLCommands;

/**
 * Created by David Stražovan on 13.06.2016.
 * Class that provides methods to work with data with embeded derby database.
 */
public class EmbededDerby implements DatabaseInterface {
    protected Connection connection;
    protected PreparedStatement insert;
    protected PreparedStatement getByID;
    protected PreparedStatement getAll;
    protected final String TableName = "";

    public EmbededDerby(String dbName)
            throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        System.out.println("Driver " + "org.apache.derby.jdbc.EmbeddedDriver" + " nacten.");
        connection = DriverManager.getConnection("jdbc:derby:" + dbName + ";create=true");
        initDB();
        prepareStatements();
    }

    private void prepareStatements() throws SQLException {
        insert = connection.prepareStatement(SQLCommands.INSERT_USER, Statement.RETURN_GENERATED_KEYS);
        getByID = connection.prepareStatement(SQLCommands.GET_BY_USERNAME);
        getAll = connection.prepareStatement(SQLCommands.GET_ALL);
    }

    private void initDB() throws SQLException {
        try (ResultSet rs = connection.getMetaData().getTables(null, null, "USERS", null);
             Statement s = connection.createStatement()) {

            if (!rs.next()) {
                s.executeUpdate(SQLCommands.CREATE_TABLE);
                System.out.println("TABLE CREATED");
            }
        }
    }


    @Override
    public boolean insert(User user) throws SQLException {
        boolean flag = false;

        try {
            insert.setString(1, user.getName());
            insert.setString(2, user.getPassword());
            insert.setString(3, user.getAPIKey());
            if (insert.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return flag;
    }

    @Override
    public User getUser(String name, String password) throws SQLException {
        try {
            getByID.setString(1, name);
            getByID.setString(2, password);
            try (ResultSet rs = getByID.executeQuery()) {
                if (rs.next()) {
                    User u = new User(rs.getString(1), rs.getString(3));
                    //u.setName(rs.getString(1));
                    //u.setAPIKey(rs.getString(3));
                    return u;
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                throw new SQLException("Failure");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public boolean deleteUser(String name) {
        return false;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        try (final ResultSet rs = getAll.executeQuery()) {
            while (rs.next()) {
                users.add(new User(rs.getString(1), rs.getString(3)));
            }
        } catch (SQLException ex) {
            throw new SQLException("Failure.");
        }
        return users;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
