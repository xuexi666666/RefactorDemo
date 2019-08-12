package exercise;

import gildedRose.GildedRose;
import gildedRose.Item;
import org.junit.Assert;
import org.junit.Test;

public class GildedRoseTest {
    @Test
    public void should_return_update_item_when_give_Age_Jordan_item(){
        //given
        Item[] items = {new Item("Age Jordan",0,1),
                new Item("Age Jordan",0,0)};
        GildedRose gildedRose = new GildedRose(items);
        //when
        gildedRose.updateQuality();
        //then
        Assert.assertEquals(0,items[0].quality);
        Assert.assertEquals(0,items[1].quality);
    }

    @Test
    public void should_return_update_item_when_give_sulfuras_item(){
        //given
        Item[] items = {new Item("Sulfuras, Hand of Ragnaros",0,1),
                new Item("Sulfuras, Hand of Ragnaros",0,0),
                new Item("Sulfuras, Hand of Ragnaros",-1,0)};
        GildedRose gildedRose = new GildedRose(items);
        //when
        gildedRose.updateQuality();
        //then
        Assert.assertEquals(1,items[0].quality);
        Assert.assertEquals(0,items[1].quality);
        Assert.assertEquals(0,items[1].sellIn);
        Assert.assertEquals(0,items[2].quality);
    }

    @Test
    public void should_return_update_item_when_give_name_and_sellin_less_than_0_and_name_is_Aged_Brie(){
        //given
        Item[] items = {new Item("Aged Brie",1,27),
                new Item("Aged Brie",0,48),
                new Item("Aged Brie",0,49),
                new Item("Aged Brie",0,50),
                new Item("Aged Brie",0,-20)};
        GildedRose gildedRose = new GildedRose(items);
        //when
        gildedRose.updateQuality();
        //then
        Assert.assertEquals(28,items[0].quality);
        Assert.assertEquals(0,items[0].sellIn);
        Assert.assertEquals(50,items[1].quality);
        Assert.assertEquals(-1,items[1].sellIn);
        Assert.assertEquals(50,items[2].quality);
        Assert.assertEquals(-1,items[2].sellIn);
        Assert.assertEquals(50,items[3].quality);
        Assert.assertEquals(-1,items[3].sellIn);
        Assert.assertEquals(-18,items[4].quality);
        Assert.assertEquals(-1,items[4].sellIn);
    }

    @Test
    public void should_return_update_item_when_give_name_and_sellin_less_than_0_and_name_is_Backstage(){
        //given
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert",0,27),
                new Item("Backstage passes to a TAFKAL80ETC concert",0,48),
                new Item("Backstage passes to a TAFKAL80ETC concert",0,49),
                new Item("Backstage passes to a TAFKAL80ETC concert",0,-20)};
        GildedRose gildedRose = new GildedRose(items);
        //when
        gildedRose.updateQuality();
        //then
        Assert.assertEquals(0,items[0].quality);
        Assert.assertEquals(-1,items[0].sellIn);
        Assert.assertEquals(0,items[1].quality);
        Assert.assertEquals(-1,items[1].sellIn);
        Assert.assertEquals(0,items[2].quality);
        Assert.assertEquals(-1,items[2].sellIn);
        Assert.assertEquals(0,items[3].quality);
        Assert.assertEquals(-1,items[3].sellIn);
    }

    @Test
    public void should_return_update_item_when_give_age_brie_and_backstage_item_quality_more_than_or_equal_50(){
        //given
        Item[] items = {new Item("Aged Brie",1,51),
                new Item("Aged Brie",0,51),
                new Item("Backstage passes to a TAFKAL80ETC concert",12,50),};
        GildedRose gildedRose = new GildedRose(items);
        //when
        gildedRose.updateQuality();
        //then
        Assert.assertEquals(0,items[0].sellIn);
        Assert.assertEquals(-1,items[1].sellIn);
        Assert.assertEquals(51,items[1].quality);
        Assert.assertEquals(11,items[2].sellIn);
    }


    @Test
    public void should_return_update_item_when_give_age_brie_and_backstage_item_and_quality_less_than_or_equal_50(){
        //given
        Item[] items = {new Item("Aged Brie",1,49),
                new Item("Backstage passes to a TAFKAL80ETC concert",12,27)};
        GildedRose gildedRose = new GildedRose(items);
        //when
        gildedRose.updateQuality();
        //then
        Assert.assertEquals(50,items[0].quality);
        Assert.assertEquals(28,items[1].quality);
        Assert.assertEquals(11,items[1].sellIn);
    }

    @Test
    public void should_return_update_item_when_give_name_not_Sulfuras_and_sellin_less_than_11(){
        //given
        Item[] items = {
                new Item("Backstage passes to a TAFKAL80ETC concert",10,27),
                new Item("Backstage passes to a TAFKAL80ETC concert",10,50),
                new Item("Backstage passes to a TAFKAL80ETC concert",11,27)};
        GildedRose gildedRose = new GildedRose(items);
        //when
        gildedRose.updateQuality();
        //then
        Assert.assertEquals(29,items[0].quality);
        Assert.assertEquals(50,items[1].quality);
        Assert.assertEquals(9,items[1].sellIn);
        Assert.assertEquals(28,items[2].quality);
    }

    @Test
    public void should_return_update_item_when_give_name_not_Sulfuras_and_sellin_less_than_6(){
        //given
        Item[] items = {
                new Item("Backstage passes to a TAFKAL80ETC concert",3,27),
                new Item("Backstage passes to a TAFKAL80ETC concert",4,48),
                new Item("Backstage passes to a TAFKAL80ETC concert",5,49),};
        GildedRose gildedRose = new GildedRose(items);
        //when
        gildedRose.updateQuality();
        //then
        Assert.assertEquals(30,items[0].quality);
        Assert.assertEquals(50,items[1].quality);
        Assert.assertEquals(50,items[2].quality);
    }

    @Test
    public void should_return_update_item_when_give_name_and_sellin_less_than_0(){
        //given
        Item[] items = {new Item("Sulfuras, Hand of Ragnaros",-1,27),
                new Item("Aged Jordan",0,1),
                new Item("Aged Jordan",0,3)};
        GildedRose gildedRose = new GildedRose(items);
        //when
        gildedRose.updateQuality();
        //then
        Assert.assertEquals(27,items[0].quality);
        Assert.assertEquals(-1,items[0].sellIn);
        Assert.assertEquals(0,items[1].quality);
        Assert.assertEquals(-1,items[1].sellIn);
        Assert.assertEquals(1,items[2].quality);
        Assert.assertEquals(-1,items[2].sellIn);
    }
}
