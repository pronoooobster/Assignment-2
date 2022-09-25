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
    public String checkSkill(){
        if(this.skill != null){
            return ("I know this skill " + skill.skillName);
        }
        else return ("I don't know any skill ");
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
    public void recoverEP(){
        if(hp != 0){
            ep += 25;
            if(ep > MAX_EP){
                ep = MAX_EP;
            }
        }
    }

    public String attack(Pokemon attacker, Pokemon target) {
        String targetStatus = "";
        double damageCoeficientToCast = TypeFunctions.battleTypes(this.type, target.getTypeRaw())* 10;

        if (attacker.getCurrentHP() <= 0) {
            return("Attack failed. " + attacker.getName() + " fainted.");
        }
            else if (target.getCurrentHP() <= 0) {
                return("Attack failed. " + target.getName() + " fainted.");
        }
                else if (attacker.getSkill() == null) {
                    return("Attack failed. " + attacker.getName() + " does not know a skill.");
        }
                    else if (attacker.getSkill() != null && attacker.getEnergy() < attacker.getSkill().energyCost) {
                            return("Attack failed. " + attacker.getName() + " lacks energy " + attacker.getEnergy() + " " + this.skill.energyCost);
        }



        else {
            target.setCurrentHP((int) (target.getCurrentHP() - attacker.getSkill().attackPower * TypeFunctions.battleTypes(this.type, target.getTypeRaw())) );
        }

        if (target.getCurrentHP() <= 0) {
            targetStatus = target.getName() + " has " + "0 HP left. " + target.getName() + " faints.";
        }
        else{
            targetStatus = target.getName() + " has " + target.getCurrentHP() + " HP left.";
        }
        switch ((int)damageCoeficientToCast) {
            case 10: return(attacker.getName() + " uses " + attacker.getSkill().skillName + " on " + target.getName() +"\n" + targetStatus);
            case 20: return(attacker.getName() + " uses " + attacker.getSkill().skillName + " on " + target.getName() + " It’s super effective!\n" + targetStatus);
            case 5: return (attacker.getName() + " uses " + attacker.getSkill().skillName + " on " + target.getName() + " It’s not very effective...\n" + targetStatus);
        }
        return null;
    }

                                                    // custom comparison function
    @Override
    public boolean equals(Object obj) {
        Pokemon pok2 = Pokemon.class.cast(obj);
        if( !(obj instanceof Pokemon) ) return false;

        boolean skillEquals = ( (this.skill == null || pok2.getSkill() == null) ? this.skill == pok2.getSkill() : this.skill.equals(pok2.getSkill()) );
        
        return (name.equals(pok2.getName()) && this.getType() == pok2.getType() && skillEquals &&
                 hp == pok2.getCurrentHP() && MAX_HP == pok2.getMAX_HP() && ep == pok2.getEnergy());
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