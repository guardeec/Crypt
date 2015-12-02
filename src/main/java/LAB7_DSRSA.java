import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by guardeec on 01.12.15.
 */
public class LAB7_DSRSA {
    public static void main(String[] args) {
        Random random = new SecureRandom();
        int length = 500;

        BigInteger text = new BigInteger(length-1, new Random());
        BigInteger p    = BigInteger.probablePrime(length, random);
        BigInteger q    = BigInteger.probablePrime(length, random);
        BigInteger n    = p.multiply(q);
        BigInteger eiler= (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        BigInteger e    = BigInteger.probablePrime(length/5, random);

        while (eiler.gcd(e).intValue() > 1) {
            e = e.add(new BigInteger("2"));
        }
        BigInteger d = e.modInverse(eiler);

        //подпись
        BigInteger ds = text.modPow(d, n);

        //проверка
        BigInteger decryptedDS = ds.modPow(e, n);

        System.out.println("text= "+text);
        System.out.println("p= "+p);
        System.out.println("q= "+q);
        System.out.println("n= "+n);
        System.out.println("eiler= "+eiler);
        System.out.println("e= "+e+" n= "+n);
        System.out.println("d= "+d+" n= "+n);
        System.out.println("text =" + text + " DS= "+ ds);
        System.out.println("text= "+text);
        System.out.println("decrDS= "+decryptedDS);
        System.out.println(text.compareTo(decryptedDS)==0 ? "Success" : false);
    }

    public static boolean checkForTest() {
        Random random = new SecureRandom();
        int length = 500;

        BigInteger text = new BigInteger(length-1, new Random());
        BigInteger p    = BigInteger.probablePrime(length, random);
        BigInteger q    = BigInteger.probablePrime(length, random);
        BigInteger n    = p.multiply(q);
        BigInteger eiler= (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        BigInteger e    = BigInteger.probablePrime(length/5, random);

        while (eiler.gcd(e).intValue() > 1) {
            e = e.add(new BigInteger("2"));
        }
        BigInteger d = e.modInverse(eiler);

        //подпись
        BigInteger ds = text.modPow(d, n);

        //проверка
        BigInteger decryptedDS = ds.modPow(e, n);

        return text.compareTo(decryptedDS)==0;
    }
}
