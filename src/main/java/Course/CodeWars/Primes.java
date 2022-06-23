package Course.CodeWars;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;


public class Primes {

    private static int[] arrPrimes = null;

    public static IntStream stream() {

        if (arrPrimes == null) {
            arrPrimes = newAtkin.getArrInt(Integer.MAX_VALUE-1);
        }

        IntStream intStream = Arrays.stream(arrPrimes);
        return intStream;
    }

}
