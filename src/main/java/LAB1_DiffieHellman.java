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

        BigInteger privateAlisa = BigInteger.probablePrime(length, random);
        BigInteger privateBob   = BigInteger.probablePrime(length, random);
        BigInteger primeNumber  = BigInteger.probablePrime(length, random);
        BigInteger primitiveRoot = PrimitiveRoot.getPrimitiveRoot(primeNumber);
        BigInteger openAlisa    = primitiveRoot.modPow(privateAlisa, primeNumber);
        BigInteger openBob      = primitiveRoot.modPow(privateBob, primeNumber);
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
