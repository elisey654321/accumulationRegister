package Course.CodeWars;

import java.lang.reflect.Method;

public class BagelSolver {

    public static Bagel getBagel() {
        // TODO : Implement me.
        Bagel bagel = new Bagel();

        try {
            Method method = bagel.getClass().getDeclaredMethod("getValue");
            System.out.println(method.getName());
            method.setAccessible(true);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        bagel.getValue();
        return bagel;
    }

    public static void main(String[] args) {
        Bagel bagel = BagelSolver.getBagel();
        if (bagel.getValue() == 4) System.out.println(true);

    }

}


