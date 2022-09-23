

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
                                                                // Function that enables a pokemon
    public void forgetSkill(){
        this.skill = null;
    }
                                                                // Function that enables asking a pokemon for it's skill
    public void checkSkill(){
        if(this.skill != null){
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

                                                    // custom comparison function
    @Override
    public boolean equals(Object obj) {
        Pokemon pok2 = Pokemon.class.cast(obj);
        if( !(obj instanceof Pokemon) ) return false;

        boolean skillEquals = ( (this.skill == null || pok2.skill == null) ? this.skill == pok2.skill : this.skill.equals(pok2.skill) );
        
        return (name.equals(pok2.name) && type == pok2.type && skillEquals &&
                 hp == pok2.hp && MAX_HP == pok2.MAX_HP && ep == pok2.ep);
    }
}
