public class Skills{
    public String skillName;
    public int attackPower;
    public int energyCost;

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
