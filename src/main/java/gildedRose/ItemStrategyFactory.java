package gildedRose;

public class ItemStrategyFactory {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public static ItemStrategy makeItemStrategy(String name) {
        switch (name) {
            case AGED_BRIE:
                return new AgedBrieStrategy();
            case BACKSTAGE_PASSES:
                return new BackStagePassesStrategy();
            case SULFURAS:
                return new SulfurasStrategy();
            default:
                return new GeneralStrategy();
        }
    }
}
