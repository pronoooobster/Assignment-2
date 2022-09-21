public class Pokemon {
                                                // 0 - Fire
                                                // 1 - Water
                                                // 2 - Grass
                                                // 3 - Normal
    public String name;
    final int MAX_HP, type, MAX_EP = 100;
    public int ep, hp;
    Skills skill;
                                                    // the default constructor
    public Pokemon(String name, int MAX_HP, int type) {
        ep = 100;
        hp = MAX_HP;
        this.name = name;
        this.MAX_HP = MAX_HP;
        this.type = type;
        this.skill = new Skills();
    }
                                                                // convert a Pokemon to a string (for output)
    public String toString() {
        if(skill.skillName != "") {
            return name + " (" + Types.values()[type].name().toLowerCase() + "). Knows " + skill.skillName + " - AP: " + skill.attackPower + " EC: " + skill.energyCost;
        } else {
            return name + " (" + Types.values()[type].name().toLowerCase() + ")";
        }
    }

                                                                // Function that enables a pokemon to learn an ability
    public void learnSkill(String skillName, int attackPower, int energyCost){
        this.skill = new Skills(skillName, attackPower, energyCost);
    }
                                                                // Function that enables a pokemon
    public void forgetSkill(){
        this.skill = new Skills("", 0,0);
    }
                                                                // Function that enables asking a pokemon for it's skill
    public void checkSkill(){
        if(this.skill.skillName != ""){
            System.out.println("I know this skill " + skill.skillName);
        }
        else System.out.println("I don't know any skill ");
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
}
