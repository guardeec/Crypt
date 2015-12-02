package BigIntegerLibs;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guardeec on 01.12.15.
 */
public class ExtGCD {

    private static List<BigInteger> list = new ArrayList<BigInteger>();

    public static BigInteger[] ExtEuclidean(BigInteger a, BigInteger b)
    {
                /*
                 * res[0] = x
                 * res[1] = y
                 * res[2] = d
                 * ax + by = d = gcd(a, b)
                 */
        BigInteger[] res = new BigInteger[3];

        if (b.compareTo(BigInteger.ZERO) == 0) {
            res[0] = BigInteger.ONE;
            res[1] = BigInteger.ZERO;
            res[2] = a;
        }
        else {
            BigInteger[] temp = ExtEuclidean(b, a.mod(b));
            res[0] = temp[1];
            res[1] = temp[0].subtract(temp[1].multiply(a.divide(b)));
            res[2] = temp[2];
        }

        return res;
    }

}
