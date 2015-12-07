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
        //BigInteger p = BigInteger.probablePrime(text.bitLength() + 1, random);
        //BigInteger g = PrimitiveRoot.getPrimitiveRoot(p);
        //BigInteger x = BigInteger.probablePrime(p.bitLength() / 2, random);
        //BigInteger y = g.modPow(x, p);
        BigInteger p = new BigInteger("6072787001443104895252590777667660895007193316271429989359546695434727371992104353150165290527787819723268387700023090638477151585360490958800437887417");
        BigInteger g = new BigInteger("1787251731469047710008474104890931086013152392776619811012632452040134519367175555668175455920417877121979282836596771350476029382921122420359409690321");
        BigInteger x = new BigInteger("1245969483849142860242808061296708761274175867035859069184952244665002281763");
        BigInteger y = new BigInteger("5630893913796114919562217555899699065088170054565766642192603394444044674805386299379645993543331927150751211059437592227262652210497855697357922289620");

        //ЭЦП
        BigInteger k = BigInteger.probablePrime(p.bitLength() / 2, new Random());
        BigInteger r = g.modPow(k, p);
        BigInteger s =  ((text.subtract(x.multiply(r))).multiply(k.modInverse(p.subtract(BigInteger.ONE)))).mod(p.subtract(BigInteger.ONE));

        //Проверка
        BigInteger left = g.modPow(text,p);
        BigInteger right = r.modPow(s, p).multiply(y.modPow(r, p)).mod(p);


        System.out.println("text= "+text);
        System.out.println("p= "+p);
        System.out.println("a= "+g);
        System.out.println("Секретный ключ x= "+x);
        System.out.println("Открытый ключ y= "+y);
        System.out.println("--------------------------------");
        System.out.println("text= "+text);
        System.out.println("k= " + k);
        System.out.println("k^-1= "+k.modInverse(p.subtract(BigInteger.ONE)));
        System.out.println("r= " + r);
        System.out.println("s= "+s);
        System.out.println("y^r mod p = "+y.modPow(r, p));
        System.out.println("r^s mod p = "+r.modPow(s, p));
        System.out.println("right = "+right);
        System.out.println("left = "+left);

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
