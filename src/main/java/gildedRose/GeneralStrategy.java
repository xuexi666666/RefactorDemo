package gildedRose;

public class GeneralStrategy implements ItemStrategy {
    @Override
    public void update(Item item) {
        if (items[i].quality > 0) {
                items[i].quality = items[i].quality - 1;
        }
        items[i].sellIn = items[i].sellIn - 1;
        if (items[i].sellIn < 0) {
            if (items[i].quality > 0) {
                items[i].quality = items[i].quality - 1;
            }
        }
    }
}
