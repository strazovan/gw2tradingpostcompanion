package utilities;

/**
 * Created by David Stražovan on 20.04.2016.
 * Enum representing types of request we need.
 */
public enum RequestType {

    CURRENT_SELL("https://api.guildwars2.com/v2/commerce/transactions/current/sells?access_token=", true),
    CURRENT_BUY("https://api.guildwars2.com/v2/commerce/transactions/current/buys?access_token=", true),
    HISTORY_SELL("https://api.guildwars2.com/v2/commerce/transactions/history/sells?access_token=", true),
    HISTORY_BUY("https://api.guildwars2.com/v2/commerce/transactions/history/buys?access_token=", true),
    ITEM_INFO("https://api.guildwars2.com/v2/items/", false),
    ACTUAL_ITEM_PRICE("https://api.guildwars2.com/v2/commerce/prices/", false);
    private final String name;


    public boolean isKeyRequired() {
        return keyRequired;
    }

    private final boolean keyRequired;

    RequestType(String s, boolean needKey) {
        name = s;
        this.keyRequired = needKey;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
