package gildedRose;

public class BackStagePassesStrategy implements ItemStrategy {
    @Override
    public void update(Item item) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].sellIn < 11) {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }

                if (items[i].sellIn < 6) {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
        items[i].sellIn = items[i].sellIn - 1;
        if (items[i].sellIn < 0) {
            items[i].quality = items[i].quality - items[i].quality;
        }
    }
}
