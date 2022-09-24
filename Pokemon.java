public class Pokemon {
                                                // 0 - Fire
                                                // 1 - Water
                                                // 2 - Grass
                                                // 3 - Normal
    public String name;
    final int MAX_HP, type, MAX_EP = 100;
    public int ep, hp;
    Skills skill = null;
                                                    // the default constructor
    public Pokemon(String name, int MAX_HP, int type) {
        ep = 100;
        hp = MAX_HP;
        this.name = name;
        this.MAX_HP = MAX_HP;
        this.type = type;
    }
                                                                // convert a Pokemon to a string (for output)
    public String toString() {
        if(skill != null) {
            return name + " (" + Types.values()[type].name().toLowerCase() + "). Knows " + skill.skillName + " - AP: " + skill.attackPower + " EC: " + skill.energyCost;
        } else {
            return name + " (" + Types.values()[type].name().toLowerCase() + ")";
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
        double damageCoeficientToCast = TypeFunctions.battleTypes(this.type, target.type)* 10;

        if (attacker.hp <= 0) {
            return("Attack failed. " + attacker.name + " fainted.");
        }
            else if (target.hp <= 0) {
                return("Attack failed." + target.name + " fainted.");
        }
                else if (attacker.skill == null) {
                    return("Attack failed. " + attacker.name + " does not know a skill.");
        }
                    else if (attacker.skill != null && attacker.ep < attacker.skill.energyCost) {
                            return("Attack failed. " + attacker.name + " lacks energy " + attacker.ep + " " +skill.energyCost);
        }



        else {
            target.hp -= attacker.skill.attackPower * TypeFunctions.battleTypes(this.type, target.type);
        }

        if (target.hp <= 0) {
            targetStatus = target.name + " has " + "0 HP left. " + target.name + " faints.";
        }
        else{
            targetStatus = target.name + " has " + target.hp + " HP left.";
        }
        switch ((int)damageCoeficientToCast) {
            case 10: return(attacker.name + " uses " + attacker.skill.skillName + " on " + target.name +"\n" + targetStatus);
            case 20: return(attacker.name + " uses " + attacker.skill.skillName + " on " + target.name + " It’s super effective!\n" + targetStatus);
            case 5: return (attacker.name + " uses " + attacker.skill.skillName + " on " + target.name + " It’s not very effective...\n" + targetStatus);
        }
        return null;
    }
}

/* Necessary changes:
* IS IT REALLY NECESSARY? -> Add a function that returns a boolean value to check if the pokemon has fainted
* DONE Change prints for returns
* DONE In the attack functions the ifs should be nested
*/