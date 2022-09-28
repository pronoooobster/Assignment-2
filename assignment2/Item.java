package assignment2;
import java.text.DecimalFormat;

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
        double truncWeight = weight;
                            // truncation to 2 digits
        truncWeight *= 100;
        int truncInt = (int) truncWeight;
        truncWeight = ((double) truncInt) / 100;
        String result = String.format("%.2f", truncWeight);
        return itemName + " heals " + healPwr + " HP. (" + result + ")";
    }
                                        // heal the pokemon
    public String heal(Pokemon pokemon) {
                        // if hp is already full
        if(pokemon.getCurrentHP() == pokemon.getMAX_HP()) {
            return pokemon.getName() + " could not use " + this.itemName + ". HP is already full.";
        }

        int hpHealed = Math.min(pokemon.getMAX_HP() - pokemon.getCurrentHP(), this.healPwr);
        pokemon.setCurrentHP( pokemon.getCurrentHP() + healPwr );
        if(pokemon.getCurrentHP() > pokemon.getMAX_HP()) {
            pokemon.setCurrentHP(pokemon.getMAX_HP());
        }
        return pokemon.getName() + " used " + this.itemName + ". It healed " + hpHealed + " HP.";
    }

    public boolean equals(Object obj) {
        if( !(obj instanceof Item) ) return false;

        Item it2 = Item.class.cast(obj);
        return (itemName.equals(it2.itemName) && healPwr == it2.healPwr && weight == it2.healPwr);
    }
}
