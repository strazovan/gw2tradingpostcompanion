package GUI;

import database.EmbededDerby;
import database.User;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

/**
 * Created by David Stražovan on 13.06.2016.
 */
public class LoginForm {
    public JPanel getPanel() {
        return panel1;
    }

    private JPanel panel1;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton loginButton;


    public LoginForm(EmbededDerby ed, JFrame parent) {


        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (nameField.getText() != "" && passwordField.getText() != "") {

                    try {
                        User user = ed.getUser(nameField.getText(), passwordField.getText());
                        if (user == null) {
                            popFailureDialog();

                        } else {

                            parent.getContentPane().removeAll();
                            parent.setLayout(new BorderLayout());
                            parent.getContentPane().add(new MainWindow(user, parent).getPanel(), BorderLayout.CENTER);
                            parent.getContentPane().doLayout();
                            parent.update(parent.getGraphics());
                            parent.setSize(new Dimension(600, 500));
                            //parent.pack();
                            System.out.println("Logged in.");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                }
            }
        });
    }

    private void popFailureDialog() {
        final JOptionPane optionPane = new JOptionPane(
                "Bad username or password.",
                JOptionPane.ERROR_MESSAGE);

        optionPane.showMessageDialog(null, "Bad Username or Password.");
        /*JDialog dialog = new JDialog(null,"Failed to log in", Dialog.ModalityType.APPLICATION_MODAL)
        dialog.setContentPane(optionPane);
        dialog.pack();
        dialog.setVisible(true);*/
    }
}
