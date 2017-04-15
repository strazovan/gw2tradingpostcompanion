package ModelClasses;

import com.google.gson.Gson;
import utilities.JSONDataDownloader;

import java.awt.*;

/**
 * Created by David Stražovan on 20.04.2016.
 * Class that represents in game item.
 */
public class Item {
    public String getName() {
        return name;
    }

    public String getRarity() {
        return rarity;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public ActualPrices getPrices() {
        return prices;
    }

    private long id;

    public long getId_item() {
        return id;
    }

    private String name;
    private String rarity;
    private String description;
    private String type;
    private int level;


    public ActualPrices prices;

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", rarity='" + rarity + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", level=" + level +
                ", prices=" + prices +
                '}';
    }

    /*
     * Method that returns color according to item's rarity as string.
     *
     */
    public String getColorStringByRarity() {
        switch (rarity) {
            case "Basic":
                return "white";

            case "Fine":
                return "blue";

            case "Masterwork":
                return "rgb(3, 184, 0)";

            case "Rare":
                return "rgb(192, 192,0)";

            case "Exotic":
                return "orange";

            case "Ascended":
                return "pink";

            case "Legendary":
                return "purple";


        }
        return "black";
    }

    /*
     * Method that returns color according to item's rarity as Color.
     */
    public Color getColorByRarity() {
        switch (rarity) {
            case "Basic":
                return Color.WHITE;

            case "Fine":
                return Color.BLUE;

            case "Masterwork":
                return new Color(3, 184, 0);

            case "Rare":
                return new Color(192, 192, 0);

            case "Exotic":
                return Color.ORANGE;

            case "Ascended":
                return Color.PINK;

            case "Legendary":
                return new Color(255, 0, 255);


        }
        return Color.BLACK;
    }
}


