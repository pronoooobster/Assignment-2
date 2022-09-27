package assignment2;
public class Pokemon {
                                                // 0 - Fire
                                                // 1 - Water
                                                // 2 - Grass
                                                // 3 - Normal
    private String name;
    private final int MAX_HP, type, MAX_EP = 100;
    private int ep, hp;
    private Skills skill = null;
                                                    // the default constructor 
    public Pokemon(String name, int MAX_HP, String type) {
        ep = 100;
        hp = MAX_HP;
        this.name = name;
        this.MAX_HP = MAX_HP;
        this.type = typeToRaw(type);
    }
                                                                // convert a Pokemon to a string (for output)
    public String toString() {
        if(skill != null) {
            return name + " (" + this.getType() + "). Knows " + skill.skillName + " - AP: " + skill.attackPower + " EC: " + skill.energyCost;
        } else {
            return name + " (" + this.getType() + ")";
        }
    }

                                                                // Function that enables a pokemon to learn an ability
    public void learnSkill(String skillName, int attackPower, int energyCost){
        this.skill = new Skills(skillName, attackPower, energyCost);
    }
                                                                // Function that enables a pokemon to forget a skill
    public void forgetSkill(){
        this.skill = null;
    }
                                                                // Function that enables asking a pokemon for it's skill
    public Boolean knowsSkill(){
        if(this.skill != null){
            return (true);
        }
        else return (false);
    }
                                                                // Function that enables a pokemon to rest and recover health
    public void rest(){
        if(hp != 0){
            hp += 20;
            if(hp > MAX_HP){
                hp = MAX_HP;
            }
        }
    }
                                                                // Function that enables a pokemon to receive damage
    public void damage(int totalDamage){
        hp -= totalDamage;
    }
                                                                // Function that enables a pokemon to recover EP
    public void recoverEnergy(){
        if(hp != 0){
            ep += 25;
            if(ep > MAX_EP){
                ep = MAX_EP;
            }
        }
    }

    public String attack(Pokemon target) {
        String targetStatus = "";
        double damageCoeficientToCast = TypeFunctions.battleTypes(this.type, target.getTypeRaw())* 10;

        if (this.getCurrentHP() <= 0) {
            return("Attack failed. " + this.getName() + " fainted.");
        }
            else if (target.getCurrentHP() <= 0) {
                return("Attack failed. " + target.getName() + " fainted.");
        }
                else if (this.getSkill() == null) {
                    return("Attack failed. " + this.getName() + " does not know a skill.");
        }
                    else if (this.getSkill() != null && this.getEnergy() < this.getSkill().energyCost) {
                            return("Attack failed. " + this.getName() + " lacks energy " + this.getEnergy() + " " + this.skill.energyCost);
        }



        else {
            target.setCurrentHP((int) Math.round(target.getCurrentHP() - this.getSkill().attackPower * TypeFunctions.battleTypes(this.type, target.getTypeRaw())) );
            this.ep -= this.skill.energyCost;
        }

        if (target.getCurrentHP() <= 0) {
            targetStatus = target.getName() + " has " + "0 HP left. " + target.getName() + " faints.";
        }
        else{
            targetStatus = target.getName() + " has " + target.getCurrentHP() + " HP left.";
        }
        switch ((int)damageCoeficientToCast) {
            case 10: return(this.getName() + " uses " + this.getSkill().skillName + " on " + target.getName() +".\n" + targetStatus);
            case 20: return(this.getName() + " uses " + this.getSkill().skillName + " on " + target.getName() + ". It is super effective!\n" + targetStatus);
            case 5: return (this.getName() + " uses " + this.getSkill().skillName + " on " + target.getName() + ". It is not very effective...\n" + targetStatus);
        }
        return null;
    }

                                                    // custom comparison function
    public boolean equals(Object obj) {
        Pokemon pok2 = Pokemon.class.cast(obj);
        if( !(obj instanceof Pokemon) ) return false;

        boolean skillEquals = ( (this.skill == null || pok2.getSkill() == null) ? this.skill == pok2.getSkill() : this.skill.equals(pok2.getSkill()) );
        
        return (name.equals(pok2.getName()) && this.getType() == pok2.getType() && skillEquals &&
                 hp == pok2.getCurrentHP() && MAX_HP == pok2.getMAX_HP() && ep == pok2.getEnergy());
    }


    public String useItem(Item item){
        return(item.heal(this));
    }

                                                    // GETers and SETers here ->
    public int getEnergy() {
        return this.ep;
    }

    public int getCurrentHP() {
        return this.hp;
    }

    public String getName() {
        return this.name;
    }

    public int getMAX_HP() {
        return this.MAX_HP;
    }

    public String getType() {
        String ans = Types.values()[type].name().toLowerCase();
        ans = ans.substring(0, 1).toUpperCase() + ans.substring(1);
        return ans;
    }

    public int getTypeRaw() {
        return this.type;
    }

    public Skills getSkill() {
        return this.skill;
    }

    public void setSkill(Skills skill) {
        this.skill = skill;
    }

    public void setCurrentHP(int hp) {
        this.hp = hp;
    }

    public void setEnergy(int ep) {
        this.ep = ep;
    }

    public int typeToRaw(String type) {
        return Types.valueOf(type.toUpperCase()).ordinal();
    }
}

/* Necessary changes:
* IS IT REALLY NECESSARY? -> Add a function that returns a boolean value to check if the pokemon has fainted
* DONE Change prints for returns
* DONE In the attack functions the ifs should be nested
*/