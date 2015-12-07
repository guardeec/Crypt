import BigIntegerLibs.PrimitiveRoot;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;


/**
 * Created by guardeec on 29.11.15.
 */
public class LAB1_DiffieHellman {
    public static void main(String[] args) {
        Random random = new SecureRandom();
        int length = 500;

        List<BigInteger> closeKeys = new LinkedList<>();
        List<BigInteger> openKeys = new LinkedList<>();

        BigInteger primeNumber  = BigInteger.probablePrime(length, random);
        BigInteger primitiveRoot = PrimitiveRoot.getPrimitiveRoot(primeNumber);

        System.out.println("Prime number= "+primeNumber);
        System.out.println("Primitive root= "+primitiveRoot);
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");

        for (int i=0; i<10; i++){
            closeKeys.add(BigInteger.probablePrime(length, random));
            openKeys.add(primitiveRoot.modPow(closeKeys.get(i), primeNumber));
        }

        //BigInteger privateAlisa = BigInteger.probablePrime(length, random);
        //BigInteger privateBob   = BigInteger.probablePrime(length, random);

        //BigInteger openAlisa    = primitiveRoot.modPow(privateAlisa, primeNumber);
        //BigInteger openBob      = primitiveRoot.modPow(privateBob, primeNumber);

/*
        BigInteger secretAlisa  = openBob.modPow(privateAlisa, primeNumber);
        BigInteger secretBob    = openAlisa.modPow(privateBob, primeNumber);

        System.out.println("privateAlisa= "+privateAlisa);
        System.out.println("privateBob= "+privateBob);
        System.out.println("PrimeNumber= "+primeNumber);
        System.out.println("PrimitiveRoot= "+primitiveRoot);
        System.out.println("OpenAlisa= "+openAlisa);
        System.out.println("OpenBob= "+openBob);
        System.out.println("SecretAlisa= "+secretAlisa);
        System.out.println("SecretBob= "+secretBob);
        System.out.println(secretAlisa.compareTo(secretBob)==0 ? "Success" : "Error");
        */

        for (int i=0; i<10; i++){
            for (int q=0; q<10; q++){
                if (i!=q){
                    System.out.println("Stroke= "+i);
                    System.out.println("Column= "+q);
                    System.out.println("Result= "+openKeys.get(q).modPow(closeKeys.get(i), primeNumber));
                    System.out.println("----------------");
                }else {
                    System.out.println("******************");
                    System.out.println("----------------");
                }
            }
        }
        System.out.println("+++++++++++++++++++++++++");
        for (int i=0; i<10; i++){
            System.out.println(openKeys.get(i));
        }
        System.out.println("+++++++++++++++++++++++++");
        for (int i=0; i<10; i++){
            System.out.println(closeKeys.get(i));
        }
    }

    public static boolean checkForTest(){
        Random random = new SecureRandom();
        int length = 500;

        BigInteger privateAlisa = BigInteger.probablePrime(length, random);
        BigInteger privateBob   = BigInteger.probablePrime(length, random);
        BigInteger primeNumber  = BigInteger.probablePrime(length, random);
        BigInteger primitiveRoot = PrimitiveRoot.getPrimitiveRoot(primeNumber);
        BigInteger openAlisa    = primitiveRoot.modPow(privateAlisa, primeNumber);
        BigInteger openBob      = primitiveRoot.modPow(privateBob, primeNumber);
        BigInteger secretAlisa  = openBob.modPow(privateAlisa, primeNumber);
        BigInteger secretBob    = openAlisa.modPow(privateBob, primeNumber);

        return secretAlisa.compareTo(secretBob) == 0;
    }
}
