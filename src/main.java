import GUI.LoginForm;
import database.EmbededDerby;

import javax.swing.*;
import java.sql.SQLException;

/*
 * testing user
 * username: testovaci
 * password: test1
 */
public class main {
    public static void main(String[] args) {
        EmbededDerby db = null;
        try {
            db = new EmbededDerby("USERS");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new LoginForm(db, frame).getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
