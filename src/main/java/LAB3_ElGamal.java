import BigIntegerLibs.PrimitiveRoot;
import org.apache.commons.math3.primes.Primes;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by guardeec on 30.11.15.
 */
public class LAB3_ElGamal {
    public static void main(String[] args) {
        Random random = new Random();
        int length = 500;

        BigInteger text = new BigInteger(length-1, random);
        BigInteger p = BigInteger.probablePrime(length, random);
        BigInteger g = PrimitiveRoot.getPrimitiveRoot(p);
        BigInteger x = BigInteger.probablePrime(p.bitLength() / 2, random);
        BigInteger y = g.modPow(x, p);

        //шифр
        Integer k = Primes.nextPrime(random.nextInt(100));
        BigInteger a = g.modPow(BigInteger.valueOf(k), p);
        BigInteger b = y.pow(k).multiply(text).mod(p);

        //дешифр
        BigInteger decrText = a.modPow(x,p).modInverse(p).multiply(b).mod(p);


        System.out.println("text= "+text);
        System.out.println("p= "+p);
        System.out.println("g= "+g);
        System.out.println("Секретный ключ x= "+x);
        System.out.println("Открытый ключ y= "+y);
        System.out.println("k= "+k);
        System.out.println("a= "+a);
        System.out.println("b= "+b);
        System.out.println("DecryptedText= "+decrText);

        System.out.println(text.compareTo(decrText)==0 ? "Success" : "Error");
    }

    public static boolean checkForTest(){

        Random random = new Random();
        int length = 500;

        BigInteger text = new BigInteger(length-1, random);
        BigInteger p = BigInteger.probablePrime(length, random);
        BigInteger g = PrimitiveRoot.getPrimitiveRoot(p);
        BigInteger x = BigInteger.probablePrime(p.bitLength() / 2, random);
        BigInteger y = g.modPow(x, p);

        //шифр
        Integer k = Primes.nextPrime(random.nextInt(100));
        BigInteger a = g.modPow(BigInteger.valueOf(k), p);
        BigInteger b = y.pow(k).multiply(text).mod(p);

        //дешифр
        BigInteger decrText = a.modPow(x,p).modInverse(p).multiply(b).mod(p);

        return text.compareTo(decrText)==0;
    }
}
