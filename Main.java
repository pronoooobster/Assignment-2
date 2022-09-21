

public class Main {
    public static void main(String[] args) {
                        // test area pokemon
        Pokemon poke1 = new Pokemon("Greg", 999, 2);
        System.out.println(poke1.toString());

        poke1.learnSkill("sleep", 0, -100);
        poke1.checkSkill();
        poke1.learnSkill("Watch TV", 0, -100);
        poke1.checkSkill();
        poke1.forgetSkill();
        poke1.checkSkill();


    }
}