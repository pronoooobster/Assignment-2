

public class Main {
    public static void main(String[] args) {
                        // test area pokemon
        Pokemon poke1 = new Pokemon("Greg", 999, 0);
        poke1.learnSkill("Sleep", 1000,-5);
        System.out.println(poke1.toString());
        Pokemon poke2 = new Pokemon("Johnny Silverhand", 420, 0);
        System.out.println(poke2.toString());

        System.out.println(poke1.attack(poke1, poke2));
    }
}