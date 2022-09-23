
public class Item {
    public final String itemName;
    public final int healPwr;
    public final double weight;
                                        // default constructor
    public Item(String itemName, int healPwr, double weight) {
        this.itemName = itemName;
        this.healPwr = healPwr;
        this.weight = weight;
    }
                                        // convert to string for printing
    public String toString() {
        double truncWeight;
                            // truncation to 2 digits
        truncWeight = weight;
        truncWeight *= 100;
        truncWeight = Math.floor(truncWeight);
        truncWeight /= 100;
        return itemName + " heals " + healPwr + " HP. (" + truncWeight + ")";
    }
                                        // heal the pokemon
    public void heal(Pokemon pokemon) {
        pokemon.hp += healPwr;
        if(pokemon.hp > pokemon.MAX_HP) {
            pokemon.hp = pokemon.MAX_HP;
        }
    }

    @Override
    public boolean equals(Object obj) {
        Item it2 = Item.class.cast(obj);
        return (itemName.equals(it2.itemName) && healPwr == it2.healPwr && weight == it2.healPwr);
    }
}
