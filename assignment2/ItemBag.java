package assignment2;

import java.util.*;

public class ItemBag {

    private final double MAX_WEIGHT;
    private double weight;
    public double getCurrentWeight() {
        return this.weight;
    }
    public double getMaxWeight() {
        return this.MAX_WEIGHT;
    }

    public ArrayList<Item> itemList = new ArrayList<>();
                                        // constructor
    public ItemBag(double MAX_WEIGHT) {
        this.MAX_WEIGHT = MAX_WEIGHT;
        weight = 0;
    }

    public int addItem(Item item) {

        if(weight + item.weight > MAX_WEIGHT) {
            return -1;
        }

        weight += item.weight;

        if(itemList.size() == 0) {
            itemList.add(item);
            return 0;
        }
                                        // insert w/ binary search
        int lp = 0, rp = itemList.size(), midInd = 0;
        while(lp < rp) {
            midInd = (lp + rp) / 2;
            double mid = (itemList.get(midInd)).weight;
            if(mid == item.weight) {
                break;
            }
                                // go left/right
            if(mid > item.weight) {
                if(lp == midInd) {
                    ++midInd;
                    break;
                }
                lp = midInd;
            } else rp = midInd;

        }
        itemList.add(midInd, item);
        return midInd;
    }

    public Item removeItemAt(int index) {
        if(index < 0 || index >= itemList.size())
            return null;
        else {
            Item result;
            
            result = itemList.get(index);
            weight -= result.weight;
            itemList.remove(index);

            return result;
        }
    }

    public String peekItemAt(int index) {
        if(index < 0 || index >= itemList.size())
            return "";

        else {return itemList.get(index).toString();}
    }

    public Item popItem() {

        if(itemList.size() == 0){
            return null;
        }

        Item result = itemList.get(0);

        weight -= result.weight;
        itemList.remove(0);
        
        return result;
    }

    public int getNumOfItems() {
        return (itemList.size());
    }
}
