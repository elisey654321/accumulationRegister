package Course.CodeWars;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static void main(String[] args) {
        //System.out.println();
        //System.out.println(fib(new BigInteger("6")));
        fib(new BigInteger("1233392"));
        //System.out.println(fib(new BigInteger("6")));
    }

    public static BigInteger fib(BigInteger n) {
        BigInteger answer = BigInteger.ZERO;
        BigInteger lastNumber1 = BigInteger.ONE;
        BigInteger lastNumber2 = BigInteger.ZERO;
        BigInteger i = BigInteger.ZERO;

        BigInteger n1 = n.multiply(n.min(BigInteger.ZERO) != BigInteger.ZERO?new BigInteger("-1"):BigInteger.ONE);

        long startTime = System.currentTimeMillis();

        while (n1.compareTo(i) > 0) {
            answer = lastNumber1.add(lastNumber2);
            lastNumber1 = lastNumber2;
            lastNumber2 = answer;
            i = i.add(BigInteger.ONE);
        }

        long time = System.currentTimeMillis() - startTime;
        System.out.println(time);

        BigInteger answerBI = n.intValue() < 0 && n.intValue()%2 == 0?answer.multiply(new BigInteger("-1")):answer;

        return answerBI;
    }

}
