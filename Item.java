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
        truncWeight = weight;
        truncWeight *= 100;
        truncWeight = Math.floor(truncWeight);
        truncWeight /= 100;
        return itemName + " heals " + healPwr + " HP. (" + truncWeight + ")";
    }

    public void heal(Pokemon pokemon) {
        pokemon.hp += healPwr;
        if(pokemon.hp > pokemon.MAX_HP) {
            pokemon.hp = pokemon.MAX_HP;
        }
    }
}
