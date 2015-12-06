import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import static BigIntegerLibs.Lab5Helper.*;

/**
 * Created by guardeec on 06.12.15.
 */
public class LAB5_InverseElem {

    public static final int BIT_LENGTH = 35;

    private static List<BigInteger> primeFactorsN1;
    private static List<BigInteger> primeFactorsN2;
    private static List<BigInteger> primeFactorsN3;

    private static BigInteger n1;
    private static BigInteger n2;
    private static BigInteger n3;

    public static void main(String[] args) throws InterruptedException {

        SecureRandom random = new SecureRandom();

        BigInteger p1 = new BigInteger(BIT_LENGTH, 5, random);
        BigInteger p2 = new BigInteger(BIT_LENGTH, 5, random);
        BigInteger p3 = new BigInteger(BIT_LENGTH, 5, random);

        n1 = getComposite(BIT_LENGTH);
        Runnable primeFactorsN1Runnable = () -> {
            System.out.println("starting n1 factorization, n1 : " + n1);
            primeFactorsN1 = primeFactors(n1, new ArrayList<>());
            System.out.println("n1 factorization finished, prime factors : " + primeFactorsN1);
        };
        Thread thread1 = new Thread(primeFactorsN1Runnable);

        n2 = getComposite(BIT_LENGTH);
        Runnable primeFactorsN2Runnable = () -> {
            System.out.println("starting n2 factorization, n2 : " + n2);
            primeFactorsN2 = primeFactors(n2, new ArrayList<>());
            System.out.println("n2 factorization finished prime factors : " + primeFactorsN2);
        };
        Thread thread2 = new Thread(primeFactorsN2Runnable);

        n3 = getComposite(BIT_LENGTH);
        Runnable primeFactorsN3Runnable = () -> {
            System.out.println("starting n3 factorization, n3 : " + n3);
            primeFactorsN3 = primeFactors(n3, new ArrayList<>());
            System.out.println("n3 factorization finished, prime factors : " + primeFactorsN3);
        };
        Thread thread3 = new Thread(primeFactorsN3Runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        BigInteger eulerFunctionN1 = eulerFunction(primeFactorsN1, n1);
        BigInteger eulerFunctionN2 = eulerFunction(primeFactorsN2, n2);
        BigInteger eulerFunctionN3 = eulerFunction(primeFactorsN3, n3);

        System.out.println("p1 : " + p1);
        System.out.println("p2 : " + p2);
        System.out.println("p3 : " + p3);
        System.out.println("n1 : " + n1);
        System.out.println("n1 prime factors : " + primeFactorsN1);
        System.out.println("n1 euler function : " + eulerFunctionN1);
        System.out.println("n2 : " + n2);
        System.out.println("n2 prime factors : " + primeFactorsN2);
        System.out.println("n2 euler function : " + eulerFunctionN2);
        System.out.println("n3 : " + n3);
        System.out.println("n3 prime factors : " + primeFactorsN3);
        System.out.println("n3 euler function : " + eulerFunctionN3);
        System.out.println("------------------------------------------------------------");

        BigInteger x1_p1;
        BigInteger x1_p2;
        BigInteger x1_p3;
        BigInteger x1_n1;
        BigInteger x1_n2;
        BigInteger x1_n3;

        for (int i = 0; i < 10; i++) {
            x1_p1 = getX(p1);
            x1_p2 = getX(p2);
            x1_p3 = getX(p3);
            x1_n1 = getX(n1);
            x1_n2 = getX(n2);
            x1_n3 = getX(n3);

            BigInteger[] gcd_x1_p1 = gcdCheckByMod(gcd(x1_p1, p1), p1);
            BigInteger[] gcd_x1_p2 = gcdCheckByMod(gcd(x1_p2, p2), p2);
            BigInteger[] gcd_x1_p3 = gcdCheckByMod(gcd(x1_p3, p3), p3);
            BigInteger[] gcd_x1_n1 = gcdCheckByMod(gcd(x1_n1, n1), n1);
            BigInteger[] gcd_x1_n2 = gcdCheckByMod(gcd(x1_n2, n2), n2);
            BigInteger[] gcd_x1_n3 = gcdCheckByMod(gcd(x1_n3, n3), n3);

            BigInteger euler_x1_p1 = euler(x1_p1, p1.subtract(BigInteger.ONE), p1);
            BigInteger euler_x1_p2 = euler(x1_p2, p2.subtract(BigInteger.ONE), p2);
            BigInteger euler_x1_p3 = euler(x1_p3, p3.subtract(BigInteger.ONE), p3);
            BigInteger euler_x1_n1 = euler(x1_n1, eulerFunctionN1, n1);
            BigInteger euler_x1_n2 = euler(x1_n2, eulerFunctionN2, n2);
            BigInteger euler_x1_n3 = euler(x1_n3, eulerFunctionN3, n3);

            System.out.println("step " + (i + 1));

            System.out.println("x1_p1 : " + x1_p1);
            System.out.println("x1_p2 : " + x1_p2);
            System.out.println("x1_p3 : " + x1_p3);
            System.out.println("x1_n1 : " + x1_n1);
            System.out.println("x1_n2 : " + x1_n2);
            System.out.println("x1_n3 : " + x1_n3);

            System.out.println("-----Euclid-----");

            System.out.println("gcd_x1_p1 : " + gcd_x1_p1[1]);
            System.out.println("gcd_x1_p2 : " + gcd_x1_p2[1]);
            System.out.println("gcd_x1_p3 : " + gcd_x1_p3[1]);
            System.out.println("gcd_x1_n1 : " + gcd_x1_n1[1]);
            System.out.println("gcd_x1_n2 : " + gcd_x1_n2[1]);
            System.out.println("gcd_x1_n3 : " + gcd_x1_n3[1]);

            System.out.println("-----Euler-----");

            System.out.println("euler_x1_p1 : " + euler_x1_p1);
            System.out.println("euler_x1_p2 : " + euler_x1_p2);
            System.out.println("euler_x1_p3 : " + euler_x1_p3);
            System.out.println("euler_x1_n1 : " + euler_x1_n1);
            System.out.println("euler_x1_n2 : " + euler_x1_n2);
            System.out.println("euler_x1_n3 : " + euler_x1_n3);

            System.out.println("------------------------------------------------------------");
        }
    }

}
