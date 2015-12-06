package BigIntegerLibs;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by guardeec on 30.11.15.
 */
public class Lab5Helper {

    public static List<BigInteger> primeFactors(BigInteger number, List<BigInteger> factors) {

        BigInteger x = BigInteger.valueOf(2);
        BigInteger y = BigInteger.ONE;

        BigInteger gcd = BigInteger.ONE;
        BigInteger stage = BigInteger.ONE;
        for (BigInteger i = BigInteger.ZERO; gcd.compareTo(BigInteger.ONE) == 0; ) {

            if (i.compareTo(stage) == 0) {
                y = x;
                stage = stage.multiply(BigInteger.valueOf(2));
            }
            x = (x.pow(2).add(BigInteger.ONE)).mod(number);
            gcd = number.gcd((x.subtract(y)).abs());

            i = i.add(BigInteger.ONE);
        }

        if (gcd.isProbablePrime(5)) {
            factors.add(gcd);
        }
        if ((number.divide(gcd)).isProbablePrime(5)) {
            factors.add(number.divide(gcd));
            return factors;
        } else {
            return primeFactors(number.divide(gcd), factors);
        }
    }


    public static BigInteger eulerFunction(List<BigInteger> primeFactors, BigInteger n) {
        Set<BigDecimal> primeFactorsSet = new HashSet<BigDecimal>();
        for (BigInteger p : primeFactors) {
            primeFactorsSet.add(new BigDecimal(p));
        }

        BigDecimal tmp = BigDecimal.ONE;
        for (BigDecimal p : primeFactorsSet) {
            BigDecimal a = BigDecimal.ONE.divide(p, 10, BigDecimal.ROUND_UP);
            BigDecimal t = BigDecimal.ONE.subtract(a);
            tmp = tmp.multiply(t);
        }
        BigDecimal phi = new BigDecimal(n).multiply(tmp);
        phi = phi.setScale(0, BigDecimal.ROUND_UP);
        return phi.toBigInteger();
    }

    public static BigInteger getX(BigInteger p) {
        BigInteger x;
        do {
            x = new BigInteger(p.bitLength(), new SecureRandom());
        } while (x.compareTo(p) > 0 || x.gcd(p).compareTo(BigInteger.ONE) != 0);
        return x;
    }

    //  return [d, a, b], d = gcd(x, y), ap + bq = d
    public static BigInteger[] gcd(BigInteger x, BigInteger y) {
        if (y.compareTo(BigInteger.ZERO) == 0)
            return new BigInteger[]{x, BigInteger.ONE, BigInteger.ZERO};

        BigInteger[] vals = gcd(y, x.mod(y));
        BigInteger d = vals[0];
        BigInteger a = vals[2];
        BigInteger b = vals[1].subtract((x.divide(y)).multiply(vals[2]));
        return new BigInteger[]{d, a, b};
    }

    //  gcd = [d, a, b]
    public static BigInteger[] gcdCheckByMod(BigInteger[] gcd, BigInteger p) {
        BigInteger[] result = new BigInteger[3];
        System.arraycopy(gcd, 0, result, 0, 3);
        if (gcd[1].compareTo(BigInteger.ZERO) < 0) {
            result[1] = gcd[1].mod(p);
        }
        if (gcd[2].compareTo(BigInteger.ZERO) < 0) {
            result[2] = gcd[2].mod(p);
        }
        return result;
    }

    public static BigInteger euler(BigInteger x, BigInteger euler, BigInteger p) {
        return (x.modPow(euler.subtract(BigInteger.ONE), p));
    }

    public static BigInteger getComposite(int bitLength) {
        BigInteger number;
        do {
            number = new BigInteger(bitLength, new SecureRandom());
        } while (number.isProbablePrime(5));
        return number;
    }
}
