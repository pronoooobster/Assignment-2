

public class Pokemon {
                                                // 0 - Fire
                                                // 1 - Water
                                                // 2 - Grass
                                                // 3 - Normal
    public String name;
    final int MAX_HP, type;
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
                                                                // convert a pokemon to a string (for output)
    public String toString() {
        if(skill.skillName != "") {
            return name + " (" + Types.values()[type].name().toLowerCase() + "). Knows " + skill.skillName + " - AP: " + skill.attackPower + " EC: " + skill.energyCost;
        } else {
            return name + " (" + Types.values()[type].name().toLowerCase() + ")";
        }
    }

    public void learnSkill(String skillName, int attackPower, int energyCost){
        this.skill = new Skills(skillName, attackPower, energyCost);
    }

    public void forgetSkill(){
        this.skill = new Skills("", 0,0);
    }

    public void checkSkill(){
        if(this.skill.skillName != ""){
            System.out.println("I know this skill " + skill.skillName);
        }
        else System.out.println("I don't know any skill ");
    }
    public void rest(){}

}
