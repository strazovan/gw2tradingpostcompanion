package ModelClasses;

/**
 * Created by David Stražovan on 25.04.2016.
 * Class that represents pricing data.
 */
public class ActualPrices {

    private static class buys {
        protected long quantity;
        protected long unitPrice;

        @Override
        public String toString() {
            return "buys{" +
                    "quantity=" + quantity +
                    ", price=" + unitPrice +
                    '}';
        }
    }

    private static class sells {
        protected long quantity;

        @Override
        public String toString() {
            return "sells{" +
                    "quantity=" + quantity +
                    ", unitPrice=" + unitPrice +
                    '}';
        }

        protected long unitPrice;


    }


    public ActualPrices.buys getBuys() {
        return buys;
    }

    public void setBuys(ActualPrices.buys buys) {
        this.buys = buys;
    }

    public sells getSell() {
        return sells;
    }

    public void setSell(sells sell) {
        this.sells = sell;
    }

    private buys buys;
    private sells sells;

    @Override
    public String toString() {
        return "ActualPrices{" +
                "buys=" + buys +
                ", sells=" + sells +
                '}';
    }
}
