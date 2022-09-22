import java.util.*;

public class ItemBag {

    Comparator<Item> compareItems = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return Double.compare(o2.weight, o1.weight);
        };
    };

    public final double MAX_WEIGHT;
    private int itemsStored;
    private double weight;
    public SortedMap<Item, Integer> itemList = new TreeMap<Item, Integer>(compareItems);

    ItemBag(double MAX_WEIGHT) {
        this.MAX_WEIGHT = MAX_WEIGHT;
        itemsStored = 0;
        weight = 0;
    }

    public void AddItem(Item item) {
        int num = ( (itemList.get(item) == null) ? 0 : itemList.get(item) );
        ++num;
        this.itemList.put(item, num);
        ++itemsStored;
        weight += item.weight;
    }

    public Item RemoveItem(int index) {
        if(index < 0 || index >= itemsStored)
            return null;
        else {
            Item result;

            result = Item.class.cast(itemList.keySet().toArray()[index]);

            --itemsStored;
            weight -= result.weight;
            itemList.put(result, itemList.get(result) - 1);
            if(itemList.get(result) <= 0) itemList.remove(result);

            return result;
        }
    }

    public String PeakItem(int index) {
        Item result;

        result = Item.class.cast(itemList.keySet().toArray()[index]);
        return result.toString();
    }

    public Item PopItem() {
        Item result;
        if(itemsStored == 0)
            return null;

        
        result = Item.class.cast(itemList.firstKey());

        --itemsStored;
        weight -= result.weight;
        itemList.put(result, itemList.get(result) - 1);
        if(itemList.get(result) <= 0) itemList.remove(result);
        return result;
    }
}
