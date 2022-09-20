0public class Pokemon {
    String name;
    int MAX_HP, type, ep, hp;
    Skills skill;
                                                    // the default constructor
    Pokemon(String name, int MAX_HP, int type) {
        ep = 100;
        hp = MAX_HP;
        this.name = name;
        this.MAX_HP = MAX_HP;
        this.type = type;
    }

    public String toString() {
        if(skill.name != "") {

        } else {
            return "No skills learned: \"" + name + " (" + Types.values()[type] + ")\"";
        }
    }

}
