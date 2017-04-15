package utilities;

import ModelClasses.ActualPrices;
import ModelClasses.Item;
import ModelClasses.Trade;
import com.google.gson.Gson;

import java.util.HashSet;


/**
 * Created by David Stražovan on 20.04.2016.
 * Class that provides methods to parse downloaded json to item class.
 */
public class Parser {

    Gson serializer;

    public Parser() {
        serializer = new Gson();
    }

    public Trade[] getTrades(String json) {
        return serializer.fromJson(json, Trade[].class);
    }

    public Item getItem(String json) {
        return serializer.fromJson(json, Item.class);
    }

    public void getPrices(HashSet<Item> items, JSONDataDownloader downloader) {
        for (Item i : items) {
            String data = downloader.getData(RequestType.ACTUAL_ITEM_PRICE, String.valueOf(i.getId_item()));
            System.out.println(data);
            ActualPrices prices = serializer.fromJson(data, ActualPrices.class);
            System.out.println(prices);
            i.prices = serializer.fromJson(data, ActualPrices.class);
            // i.prices.setBuys(serializer.fromJson(serializer.));

        }
    }

}
