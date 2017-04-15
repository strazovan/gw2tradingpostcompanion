package GUI;

import ModelClasses.Item;
import ModelClasses.Trade;
import database.User;
import utilities.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Created by David Stražovan on 13.06.2016.
 */
public class MainWindow {
    private JTabbedPane tabbedPane1;

    User user;
    JFrame parent;

    public JPanel getPanel() {
        return panel1;
    }

    long profit;
    ArrayList<Item> items;
    private JPanel panel1;
    private JPanel ActualBuysPanel;
    private JPanel HistorySellsPanel;
    private JPanel ActualSellsPanel;
    private JPanel HistoryBuysPanel;
    private JLabel Profit;
    private JButton refreshButton;

    public MainWindow(User u, JFrame parent) {
        this.parent = parent;
        this.user = u;

    }


    private void loadData(User u, JFrame parent) {

        JSONDataDownloader json = new JSONDataDownloader(u.getAPIKey());
        Parser parser = new Parser();
        Trade[] trades;
        JPanel content;
        RequestType[] requests = {RequestType.CURRENT_BUY, RequestType.CURRENT_SELL, RequestType.HISTORY_BUY, RequestType.HISTORY_SELL};
        items = new ArrayList<>();
        for (RequestType current : requests) {
            trades = parser.getTrades(json.getData(current, ""));
            for (Trade t :
                    trades) {
                if (current == RequestType.HISTORY_BUY)
                    profit -= t.getPrice();
                else if (current == RequestType.HISTORY_SELL)
                    profit += t.getPrice();

                Item item = parser.getItem(json.getData(RequestType.ITEM_INFO, String.valueOf(t.getItemId())));
                items.add(item);
                long[] price = t.getNormalizedPrice();
                JButton b = new ItemButton(item, t);
                switch (current) {
                    case CURRENT_BUY:
                        ActualBuysPanel.add(b);
                        break;
                    case CURRENT_SELL:
                        ActualSellsPanel.add(b);
                        break;
                    case HISTORY_BUY:
                        HistoryBuysPanel.add(b);
                        break;
                    case HISTORY_SELL:
                        HistorySellsPanel.add(b);
                        break;
                }
            }

        }

    }

    private void createUIComponents() {
        panel1 = new JPanel();
        //panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        panel1.setLayout(new BorderLayout());
        panel1.setSize(new Dimension(parent.getWidth(), 500));

        ActualBuysPanel = new JPanel();
        HistorySellsPanel = new JPanel();
        ActualSellsPanel = new JPanel();
        HistoryBuysPanel = new JPanel();


        tabbedPane1 = new JTabbedPane();
        tabbedPane1.setPreferredSize(new Dimension(parent.getWidth(), 400));

        tabbedPane1.addTab("Actual Buys", new JScrollPane(ActualBuysPanel));
        tabbedPane1.addTab("Actual Sells", new JScrollPane((ActualSellsPanel)));
        tabbedPane1.addTab("History Buys", new JScrollPane(HistoryBuysPanel));
        tabbedPane1.addTab("History Sells", new JScrollPane(HistorySellsPanel));
        ActualBuysPanel.setLayout(new BoxLayout(ActualBuysPanel, BoxLayout.Y_AXIS));
        HistorySellsPanel.setLayout(new BoxLayout(HistorySellsPanel, BoxLayout.Y_AXIS));
        ActualSellsPanel.setLayout(new BoxLayout(ActualSellsPanel, BoxLayout.Y_AXIS));
        HistoryBuysPanel.setLayout(new BoxLayout(HistoryBuysPanel, BoxLayout.Y_AXIS));


        panel1.add(tabbedPane1, BorderLayout.CENTER);
        loadData(user, parent);

        long[] normalizedProfit = Trade.getNormalizedPrice(profit);
        Profit = new JLabel(String.format("%s : %d g %d s %d c", "Total profit is:", normalizedProfit[0], normalizedProfit[1], normalizedProfit[2]));
        JPanel profitPanel = new JPanel();
        profitPanel.add(Profit);
        parent.add(profitPanel, BorderLayout.NORTH);


        refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActualSellsPanel.removeAll();
                ActualBuysPanel.removeAll();
                HistoryBuysPanel.removeAll();
                HistorySellsPanel.removeAll();
                loadData(user, parent);
            }
        });

        JPanel refreshPanel = new JPanel();
        refreshPanel.add(refreshButton);
        parent.add(refreshPanel, BorderLayout.SOUTH);

    }
}
