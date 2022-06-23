package Course.CodeWars;

import java.util.Arrays;
import java.util.List;

public class Kata1 {
    public static int summation(int n) {
        int result = 0;
        for (int i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }
}
