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

        /*
        p = new BigInteger("3100930328898652513317285571655677664047725854618829831709143542391593803773514804643562500925568292413530938238610691849837944030031639860809365682619");
        g = new BigInteger("1518507402571823868904801137766954426141063458044374773505062402215941975720353194189980204999182977014282235103324633916091017592577653890671078040343");
        x = new BigInteger("1030867469210431800439855008942525859960286239684449821094620764103910181589");
        y = new BigInteger("1770221937318310034399888609501613201853325802133700500500134455381921305114478783184441484262907341791964193173880945102582103881392183586114250035031");
        */

        //шифр
        BigInteger k = BigInteger.probablePrime(length/2, random);
        BigInteger a = g.modPow(k, p);
        BigInteger b = y.modPow(k,p).multiply(text).mod(p);

        //дешифр
        BigInteger decrText = a.modPow(x,p).modInverse(p).multiply(b).mod(p);


        System.out.println("text= "+text);
        System.out.println("p= "+p);
        System.out.println("основание а= "+g);
        System.out.println("Секретный ключ x= "+x);
        System.out.println("Открытый ключ y= "+y);
        System.out.println("----------------------");
        System.out.println("text= "+text);
        System.out.println("R= "+k);
        System.out.println("R^-1= "+k.modInverse(p));
        System.out.println("C`= "+a);
        System.out.println("C``= "+b);
        System.out.println("Z= "+g.modPow(k.multiply(x), p));
        System.out.println("Z`= "+g.modPow(k.multiply(x), p).modInverse(p));
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
