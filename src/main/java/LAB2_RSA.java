import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by guardeec on 30.11.15.
 */
public class LAB2_RSA {
    public static void main(String[] args) {
        Random random = new SecureRandom();
        int length = 500;

        BigInteger text = new BigInteger(length-1, random);
        BigInteger p    = BigInteger.probablePrime(length, random);
        BigInteger q    = BigInteger.probablePrime(length, random);
        BigInteger n    = p.multiply(q);
        BigInteger eiler= (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        BigInteger e    = BigInteger.probablePrime(length/2, random);

        while (eiler.gcd(e).intValue() > 1) {
            e = e.add(new BigInteger("2"));
        }
        BigInteger d    = e.modInverse(eiler);

        //шифр
        BigInteger crypt= text.modPow(e, n);

        //дешифр
        BigInteger decryptedText = crypt.modPow(d, n);


        System.out.println("text= "+text);
        System.out.println("p= "+p);
        System.out.println("q= "+q);
        System.out.println("n= "+n);
        System.out.println("eiler= "+eiler);
        System.out.println("e= "+e+" n= "+n);
        System.out.println("d= "+d+" n= "+n);
        System.out.println("crypt =" + crypt);
        System.out.println("DecryptedText ="+decryptedText);

        System.out.println(decryptedText.compareTo(text)==0 ? "Success" : "Error");
    }

    public static boolean checkForTest(){
        Random random = new SecureRandom();
        int length = 500;

        BigInteger text = new BigInteger(length-1, random);
        BigInteger p    = BigInteger.probablePrime(length, random);
        BigInteger q    = BigInteger.probablePrime(length, random);
        BigInteger n    = p.multiply(q);
        BigInteger eiler= (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        BigInteger e    = BigInteger.probablePrime(length/2, random);

        while (eiler.gcd(e).intValue() > 1) {
            e = e.add(new BigInteger("2"));
        }
        BigInteger d    = e.modInverse(eiler);

        //шифр
        BigInteger crypt= text.modPow(e, n);

        //дешифр
        BigInteger decryptedText = crypt.modPow(d, n);

        return decryptedText.compareTo(text)==0;
    }
}
