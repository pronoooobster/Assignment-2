

public class Main {
    public static void main(String[] args) {
                        // test area pokemon
        Pokemon poke1 = new Pokemon("Greg", 999, 2);
        Pokemon poke2 = new Pokemon("Walter white", 999, 2);
        poke1.learnSkill("eat ramen", 2, 20);
        poke1.learnSkill("cook meth", 2, 20);

        System.out.println(poke1.equals(poke2));
    }
}