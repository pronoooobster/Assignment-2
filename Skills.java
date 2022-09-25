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
                                        // custom comparison function
    @Override
    public boolean equals(Object obj) {
        if( !(obj instanceof Skills) ) return false;

        Skills skl2 = Skills.class.cast(obj);
        return (skillName == skl2.skillName && attackPower == skl2.attackPower && energyCost == skl2.energyCost);
    }
}
