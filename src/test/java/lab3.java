import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guardeec on 30.11.15.
 */
public class lab3 {
    @Test
    public void test_lab3(){
        for (int i=0; i<100; i++){
            System.out.println("Iteration "+i+" Success");
            if (!LAB3_ElGamal.checkForTest()){
                Assert.fail();
            }
        }
    }
}
