package GUI;

import ModelClasses.Item;
import ModelClasses.Trade;

import javax.swing.*;
import java.awt.*;

/**
 * Created by David Stražovan on 16.06.2016.
 */
public class ItemWindow {
    private JPanel panel1;

    private Item item;
    private Trade trade;

    public Container getPanel() {
        return panel1;
    }

    public ItemWindow(Item item, Trade trade) {
        this.item = item;
        this.trade = trade;
    }

    private void createUIComponents() {

        panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(new JLabel(String.format("<html><b>%s</b>: %s</html>", "Item name", item.getName())));
        panel1.add(new JLabel(String.format("<html><b>%s</b>: <font color='%s'>%s</font></html>", "Rarity", item.getColorStringByRarity(), item.getRarity())));
        panel1.add(new JLabel(String.format("<html><b>%s</b>: %s</html>", "Trade created", trade.getCreated())));
        panel1.add(new JLabel(String.format("<html><b>%s</b>: %s</html>", "Trade finished:", trade.getPurchased() != null ? trade.getPurchased() : "not yet")));

        long[] price = trade.getNormalizedPrice();
        panel1.add(new JLabel(String.format("<html><b>%s</b> : %s g %s s %s c</html>", "Trade price", String.valueOf(price[0]), String.valueOf(price[1]), String.valueOf(price[2]))));
    }
}
