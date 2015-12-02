import BigIntegerLibs.PrimitiveRoot;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by guardeec on 01.12.15.
 */
public class LAB6_DSElGamal {
    public static void main(String[] args) {
        Random random = new SecureRandom();
        int length = 500;

        BigInteger text = new BigInteger(length, random);
        BigInteger p = BigInteger.probablePrime(text.bitLength() + 1, random);
        BigInteger g = PrimitiveRoot.getPrimitiveRoot(p);
        BigInteger x = BigInteger.probablePrime(p.bitLength() / 2, random);
        BigInteger y = g.modPow(x, p);

        //ЭЦП
        BigInteger k = BigInteger.probablePrime(p.bitLength() / 2, new Random());
        BigInteger r = g.modPow(k, p);
        BigInteger s =  ((text.subtract(x.multiply(r))).multiply(k.modInverse(p.subtract(BigInteger.ONE)))).mod(p.subtract(BigInteger.ONE));

        //Проверка
        BigInteger left = g.modPow(text,p);
        BigInteger right = r.modPow(s, p).multiply(y.modPow(r, p)).mod(p);


        System.out.println("text= "+text);
        System.out.println("p= "+p);
        System.out.println("g= "+g);
        System.out.println("Секретный ключ x= "+x);
        System.out.println("Открытый ключ y= "+y);
        System.out.println("k= " + k);
        System.out.println("r= " + r);
        System.out.println("s= "+s);
        System.out.println("left = "+left);
        System.out.println("right = "+right);
        System.out.println(left.compareTo(right)==0 ? "Success" : "Error");
    }

    public static boolean checkForTest() {
        Random random = new SecureRandom();
        int length = 500;

        BigInteger text = new BigInteger(length, random);
        BigInteger p = BigInteger.probablePrime(text.bitLength() + 1, random);
        BigInteger g = PrimitiveRoot.getPrimitiveRoot(p);
        BigInteger x = BigInteger.probablePrime(p.bitLength() / 2, random);
        BigInteger y = g.modPow(x, p);

        //ЭЦП
        BigInteger k = BigInteger.probablePrime(p.bitLength() / 2, new Random());
        BigInteger r = g.modPow(k, p);
        BigInteger s =  ((text.subtract(x.multiply(r))).multiply(k.modInverse(p.subtract(BigInteger.ONE)))).mod(p.subtract(BigInteger.ONE));

        //Проверка
        BigInteger left = g.modPow(text,p);
        BigInteger right = r.modPow(s, p).multiply(y.modPow(r, p)).mod(p);

        return left.compareTo(right)==0;
    }
}
