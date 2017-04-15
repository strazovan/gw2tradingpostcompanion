package testing;

import GUI.LoginForm;
import ModelClasses.Item;
import ModelClasses.Trade;
import database.EmbededDerby;
import database.User;
import utilities.JSONDataDownloader;
import utilities.Parser;
import utilities.RequestType;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by David Stražovan on 20.04.2016.
 */
public class Test {

    public static void main(String args[]) throws SQLException, ClassNotFoundException {


        EmbededDerby db = new EmbededDerby("USERS");


        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new LoginForm(db, frame).getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

}
