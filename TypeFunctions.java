/*Function that will retourn the damage multiplier when called in battle, based on the attacker and defender type */

public class TypeFunctions {

    public static double battleTypes(int attacker, int target) {
        if (attacker == 0) {
            switch (target) {
                case (0):
                    return 0.5;

                case (1):
                    return 0.5;

                case (2):
                    return 2.0;

                default:
                    return 1.0;
            }
                }
        else if(attacker == 1){
            switch (target) {
                case (0):
                    return 2.0;

                case (1):
                    return 0.5;

                case (2):
                    return 0.5;

                default:
                    return 1.0;
        }

    }
        else if(attacker == 2){
            switch (target) {
            case (0):
                return 0.5;

            case (1):
                return 2.0;

            case (2):
                return 0.5;

            default:
                return 1.0;
    }
    

}
        else return 1.0;

    }
}
