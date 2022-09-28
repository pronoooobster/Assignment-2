package assignment2;

public class Main {
    public static void main(String[] args) {
                        // test area pokemon
                        
        Pokemon poke1 = new Pokemon("Greg", 999, "Fire");
        poke1.learnSkill("Sleep", 1000,10);
        System.out.println(poke1.toString());
        Pokemon poke2 = new Pokemon("Johnny Silverhand", 420, "Grass");
        poke2.learnSkill("Smoke", 100, 1);
        System.out.println(poke2.toString());

        System.out.println(poke1.attack(poke2));
        System.out.println(poke1.attack(poke1));
    }
}