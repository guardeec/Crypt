package BigIntegerLibs;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guardeec on 30.11.15.
 */
public class Factorisation {
    private static List primes = new ArrayList();

    public static List getFactorisation(BigInteger number) {
        System.out.println("Start Fact");
        recurse(number);
        for(int i = 0; i < primes.size(); i++)
            System.out.print(primes.get(i).toString() + ", ");

        System.out.println();
        System.out.println("End Fact");
        return primes;
    }
    private static void recurse(BigInteger num) {
        BigInteger i = new BigInteger("2");
        //we use these as "constants" later
        final BigInteger zero = new BigInteger("0");
        final BigInteger one = new BigInteger("1");
        //base case, num = 2; reuse i on our way
        if(num.equals(i)) {
            primes.add(i);
            return;
        }
        for(; !num.mod(i).equals(zero); i = i.add(one)) {
            if(num.subtract(i).subtract(i).signum() == -1) { //this number is prime
                primes.add(num);
                return;
            }
        }
        //we found two divisors, recurse them
        recurse(i);
        recurse(num.divide(i));
    }
}
