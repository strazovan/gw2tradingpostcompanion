package GUI;

import ModelClasses.Item;
import ModelClasses.Trade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by David Stražovan on 16.06.2016.
 */
public class ItemButton extends JButton {

    private Item item;
    private Trade trade;

    public ItemButton(Item i, Trade t) {
        this.trade = t;
        this.item = i;
        initButton();
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame(i.getName());
                f.setContentPane(new ItemWindow(i, t).getPanel());
                f.setSize(new Dimension(300, 200));
                f.setVisible(true);
            }
        });

    }

    private void initButton() {

        long[] price = trade.getNormalizedPrice();
        String text = String.format("<html><b>%-70s</b> %4d g %2d s %2d c </html>", item.getName(), price[0], price[1], price[2]);
        setText(text);
        setForeground(item.getColorByRarity());
        // setBackground(Color.BLACK);

        //setPreferredSize(new Dimension(600,400));
    }

}
