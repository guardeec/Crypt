package BigIntegerLibs;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

/**
 * Created by guardeec on 30.11.15.
 */
public class Diafant {

    public static BigInteger[] getRoots(BigInteger a, BigInteger b){
        BigInteger x;
        BigInteger y;
        BigInteger z = BigInteger.ONE;
        BigInteger biggest = getBiggest(a, b);
        for (
                BigInteger i = BigInteger.ONE;
                z.mod(b).compareTo(BigInteger.ZERO)!=0 || z.add(BigInteger.ONE).mod(a).compareTo(BigInteger.ZERO)!=0;
                i = i.add(BigInteger.ONE)
                ){

            //z = biggest.multiply(i);
            z = i;
            //System.out.println(z);
        }

        x = z.add(BigInteger.ONE).divide(a);
        y = z.multiply(BigInteger.valueOf(-1)).divide(b);

        return new BigInteger[]{x,y};
    }

    private static BigInteger getBiggest(BigInteger a, BigInteger b){
        return a.compareTo(b)>0 ? a : b;
    }
}

