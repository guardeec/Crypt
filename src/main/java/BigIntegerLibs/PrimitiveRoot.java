package BigIntegerLibs;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by guardeec on 30.11.15.
 */
public class PrimitiveRoot {

    public static BigInteger getPrimitiveRootOld(BigInteger number){
        List<BigInteger> factorisation = Factorisation.getFactorisation(number.subtract(new BigInteger("1")));
        List<BigInteger> checkExp = new LinkedList<BigInteger>();
        for (BigInteger bigInteger : factorisation){
            if (!checkExp.contains(bigInteger)){
                checkExp.add(bigInteger);
            }
        }

        boolean testIsPassed = false;
        BigInteger primitiveRoot;
        do {
            primitiveRoot = BigInteger.probablePrime(number.bitLength(), new Random());
            List<Boolean> testIsPassedList = new LinkedList<Boolean>();

            for (BigInteger exponent : checkExp){

                System.out.println(primitiveRoot + " ^ " + exponent + " = " + primitiveRoot.modPow(exponent, number) + " mod " + number);
                if (primitiveRoot.modPow(exponent, number)==new BigInteger("1")){
                    testIsPassedList.add(false);
                }else {
                    testIsPassedList.add(true);
                }
            }
            testIsPassed = !testIsPassedList.contains(false);
        }while (!testIsPassed);

        return primitiveRoot;
    }

    public static BigInteger getPrimitiveRoot(BigInteger number){

        BigInteger primitiveRoot;
        do {
            primitiveRoot = BigInteger.probablePrime(number.bitLength()-1, new Random());
        }while (primitiveRoot.modPow(number.subtract(BigInteger.ONE), number).compareTo(BigInteger.ONE)!=0);

        return primitiveRoot;
    }

}
