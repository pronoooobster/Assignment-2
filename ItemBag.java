

import java.util.*;

public class ItemBag {

    public final double MAX_WEIGHT;
    public double weight;
    public ArrayList<Item> itemList = new ArrayList<Item>();
                                        // constructor
    public ItemBag(double MAX_WEIGHT) {
        this.MAX_WEIGHT = MAX_WEIGHT;
        weight = 0;
    }

    public int AddItem(Item item) {
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

    public Item RemoveItem(int index) {
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

    public String PeakItem(int index) {
        return itemList.get(index).toString();
    }

    public Item PopItem() {
        Item result = itemList.get(0);
        
        weight -= result.weight;
        itemList.remove(0);
        
        return result;
    }
}
