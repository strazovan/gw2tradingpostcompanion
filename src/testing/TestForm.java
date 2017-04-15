package testing;

import ModelClasses.Trade;
import utilities.JSONDataDownloader;
import utilities.Parser;
import utilities.RequestType;

import javax.swing.*;
import java.awt.*;

/**
 * Created by David Stražovan on 13.06.2016.
 */
public class TestForm {

    public JPanel getPanel() {
        return panel1;
    }

    private JPanel panel1;

    public TestForm() {
        panel1.setLayout(new FlowLayout());

        JSONDataDownloader jd = new JSONDataDownloader(".");
        Parser p = new Parser();
        Trade[] trades = p.getTrades(jd.getData(RequestType.HISTORY_SELL, ""));
        for (Trade t :
                trades) {
            JButton jb = new JButton(String.valueOf(t.getItemId()));
            panel1.add(jb);
        }
    }


}
