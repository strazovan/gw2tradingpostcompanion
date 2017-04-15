package ModelClasses;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by David Stražovan on 25.04.2016.
 * Class that provides information about trade and methods for formatting price.
 */
public class Trade {
    private long id;
    private long item_id;
    private long price;
    private int quantity;
    private String created;
    private String purchased;

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", itemId=" + item_id +
                ", price=" + price +
                ", quantity=" + quantity +
                ", created='" + created + '\'' +
                ", purchased='" + purchased + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public long getItemId() {
        return item_id;
    }

    public long getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCreated() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        try {
            return dateFormat.parse(created).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getPurchased() {
        if (purchased == null)
            return null;

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        try {
            return dateFormat.parse(purchased).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * Method that parse item's price in copper into gold,silver, copper.
     */
    public long[] getNormalizedPrice() {
        long price = this.price;
        long gold = price / 10000;
        long silver = (price % 10000) / 100;
        long bronze = price - (gold * 10000 + silver * 100);
        return new long[]{gold, silver, bronze};
    }

    /*
    * Method that parse item's price in copper into gold,silver, copper.
    */
    public static long[] getNormalizedPrice(long priceInCopper) {
        long price = priceInCopper;
        long gold = price / 10000;
        long silver = (price % 10000) / 100;
        long bronze = price - (gold * 10000 + silver * 100);
        return new long[]{gold, silver, bronze};
    }
}
