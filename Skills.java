public class Skills{
    public final String skillName;
    public final int attackPower;
    public final int energyCost;

    Skills(String skillName, int attackPower, int energyCost) {
        this.skillName = skillName;
        this.attackPower = attackPower;
        this.energyCost = energyCost;
    }

    Skills() {
        this.skillName = "";
        this.energyCost = 0;
        this.attackPower = 0;
    }


}
