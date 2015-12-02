import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by guardeec on 01.12.15.
 */
public class LAB8_Chaum {
    public static void main(String[] args) {
        Random random = new SecureRandom();
        int length = 500;

        BigInteger text = new BigInteger(length-1, new Random());
        BigInteger p    = BigInteger.probablePrime(length, random);
        BigInteger q    = BigInteger.probablePrime(length, random);
        BigInteger n    = p.multiply(q);
        BigInteger eiler= (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        BigInteger e = BigInteger.probablePrime(length/5, random);
        while (eiler.gcd(e).intValue() > 1) {
            e = e.add(new BigInteger("2"));
        }
        BigInteger d = e.modInverse(eiler);

        BigInteger k;
        do {
            k = new BigInteger(500, new SecureRandom());
        } while (k.gcd(n).compareTo(BigInteger.ONE) != 0);

        BigInteger changedText = (text.multiply(k.modPow(e, n))).mod(n);
        BigInteger sBlind = changedText.modPow(d, n);
        BigInteger s =  (sBlind.multiply(k.modInverse(n))).mod(n);
        BigInteger vSign = text.modPow(d, n);


        System.out.println("text= "+text);
        System.out.println("p= "+p);
        System.out.println("q= "+q);
        System.out.println("n= "+n);
        System.out.println("eiler= "+eiler);
        System.out.println("e= "+e);
        System.out.println("d= "+d);
        System.out.println("k= "+k);
        System.out.println("M`= "+changedText);
        System.out.println("S`= "+sBlind);
        System.out.println("S = "+s);
        System.out.println("Md = "+vSign);

        System.out.println(s.compareTo(vSign)==0 ? "Success" : "Error");
    }

    public static boolean checkForTest() {
        Random random = new SecureRandom();
        int length = 500;

        BigInteger text = new BigInteger(length-1, new Random());
        BigInteger p    = BigInteger.probablePrime(length, random);
        BigInteger q    = BigInteger.probablePrime(length, random);
        BigInteger n    = p.multiply(q);
        BigInteger eiler= (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        BigInteger e = BigInteger.probablePrime(length/5, random);
        while (eiler.gcd(e).intValue() > 1) {
            e = e.add(new BigInteger("2"));
        }
        BigInteger d = e.modInverse(eiler);

        BigInteger k;
        do {
            k = new BigInteger(500, new SecureRandom());
        } while (k.gcd(n).compareTo(BigInteger.ONE) != 0);

        BigInteger changedText = (text.multiply(k.modPow(e, n))).mod(n);
        BigInteger sBlind = changedText.modPow(d, n);
        BigInteger s =  (sBlind.multiply(k.modInverse(n))).mod(n);
        BigInteger vSign = text.modPow(d, n);

        return s.compareTo(vSign)==0;
    }
}
