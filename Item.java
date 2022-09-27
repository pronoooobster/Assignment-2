

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
        pokemon.setCurrentHP( pokemon.getCurrentHP() + healPwr );
        if(pokemon.getCurrentHP() > pokemon.getMAX_HP()) {
            pokemon.setCurrentHP(pokemon.getMAX_HP());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if( !(obj instanceof Item) ) return false;

        Item it2 = Item.class.cast(obj);
        return (itemName.equals(it2.itemName) && healPwr == it2.healPwr && weight == it2.healPwr);
    }
}
