package Course.CodeWars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class newAtkin {

    public static int[] getArrInt(int limit){

        boolean[] sieve = new boolean[limit + 1];
        int limitSqrt = (int)Math.sqrt((double)limit);

        Arrays.fill(sieve, false);

        sieve[0] = false;
        sieve[1] = false;
        sieve[2] = true;
        sieve[3] = true;

        for (int x = 1; x <= limitSqrt; x++) {
            for (int y = 1; y <= limitSqrt; y++) {

                int n = (4 * x * x) + (y * y);
                if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {
                    sieve[n] = !sieve[n];
                }
                n = (3 * x * x) + (y * y);
                if (n <= limit && (n % 12 == 7)) {
                    sieve[n] = !sieve[n];
                }
                n = (3 * x * x) - (y * y);
                if (x > y && n <= limit && (n % 12 == 11)) {
                    sieve[n] = !sieve[n];
                }
            }
        }

        for (int n = 5; n <= limitSqrt; n++) {
            if (sieve[n]) {
                int x = n * n;
                for (int i = x; i <= limit; i += x) {
                    sieve[i] = false;
                }
            }
        }

        List<Integer> integerList = new ArrayList<>();

        for (int i = 0, j = 0; i <= limit; i++) {
            if (sieve[i]) {
                integerList.add(i);
            }
        }

        int[] result = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            result[i] = integerList.get(i);
        }
        return result;
    }

}
