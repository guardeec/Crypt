import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by guardeec on 30.11.15.
 */
public class LAB4_Rabin {
    public static void main(String[] args) {

        BigInteger p;
        BigInteger q;
        do {
            q = new BigInteger(500, 5, new SecureRandom());
        } while (!isThreeModFour(q));
        do {
            p = new BigInteger(500, 5, new SecureRandom());
        } while (!isThreeModFour(p));

        BigInteger n = p.multiply(q);
        BigInteger text = BigInteger.probablePrime(n.bitLength()/2, new Random());

        System.out.println();
        System.out.println(n.bitLength());
        System.out.println(text.bitLength());

        //шифр
        BigInteger cypher = text.modPow(BigInteger.valueOf(2), n);

        //дешифр
        BigInteger Mp1  = cypher.modPow(p.add(BigInteger.ONE).divide(BigInteger.valueOf(4)), p);
        BigInteger Mp2  = p.subtract(Mp1);
        BigInteger Mq1  = cypher.modPow(q.add(BigInteger.ONE).divide(BigInteger.valueOf(4)), q);
        BigInteger Mq2  = q.subtract(Mq1);
        BigInteger a    = q.multiply(q.modInverse(p));
        BigInteger b    = p.multiply(p.modInverse(q));


        BigInteger M1 = Mp1.multiply(a).add(Mq1.multiply(b)).mod(n);
        BigInteger M2 = Mp1.multiply(a).add(Mq2.multiply(b)).mod(n);
        BigInteger M3 = Mp2.multiply(a).add(Mq1.multiply(b)).mod(n);
        BigInteger M4 = Mp2.multiply(a).add(Mq2.multiply(b)).mod(n);

        System.out.println("p= "+p);
        System.out.println("q= "+q);
        System.out.println("n= "+n);
        System.out.println("text= "+text);
        System.out.println("cypher= "+cypher);
        System.out.println("Mp1= "+Mp1);
        System.out.println("Mp2= "+Mp2);
        System.out.println("Mq1= "+Mq1);
        System.out.println("Mq2= "+Mq2);
        System.out.println("a= "+a);
        System.out.println("b= "+b);
        System.out.println("-------------------");
        System.out.println("Message 1 = "+M1);
        System.out.println("Message 2 = "+M2);
        System.out.println("Message 3 = "+M3);
        System.out.println("Message 4 = "+M4);
        System.out.println("Origianl Text = "+text);
    }

    private static boolean isThreeModFour(BigInteger checked) {
        return checked.mod(BigInteger.valueOf(4)).compareTo(BigInteger.valueOf(3)) == 0;
    }

    public static boolean checkForTest() {
        BigInteger p;
        BigInteger q;
        do {
            q = new BigInteger(500, 5, new SecureRandom());
        } while (!isThreeModFour(q));
        do {
            p = new BigInteger(500, 5, new SecureRandom());
        } while (!isThreeModFour(p));
        BigInteger n = p.multiply(q);
        BigInteger text = BigInteger.probablePrime(n.bitLength()/2, new Random());

        //шифр
        BigInteger cypher = text.modPow(BigInteger.valueOf(2), n);

        //дешифр
        BigInteger Mp1  = cypher.modPow(p.add(BigInteger.ONE).divide(BigInteger.valueOf(4)), p);
        BigInteger Mp2  = p.subtract(Mp1);
        BigInteger Mq1  = cypher.modPow(q.add(BigInteger.ONE).divide(BigInteger.valueOf(4)), q);
        BigInteger Mq2  = q.subtract(Mq1);
        BigInteger a    = q.multiply(q.modInverse(p));
        BigInteger b    = p.multiply(p.modInverse(q));


        BigInteger M1 = Mp1.multiply(a).add(Mq1.multiply(b)).mod(n);
        BigInteger M2 = Mp1.multiply(a).add(Mq2.multiply(b)).mod(n);
        BigInteger M3 = Mp2.multiply(a).add(Mq1.multiply(b)).mod(n);
        BigInteger M4 = Mp2.multiply(a).add(Mq2.multiply(b)).mod(n);

        boolean test = false;
        if (
                M1.compareTo(text)==0 ||
                        M1.compareTo(text)==0 ||
                        M2.compareTo(text)==0 ||
                        M3.compareTo(text)==0 ||
                        M4.compareTo(text)==0
                ){
            test = true;
        }
        return test;
    }
}
