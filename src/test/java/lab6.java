import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guardeec on 01.12.15.
 */
public class lab6 {
    @Test
    public void test_lab6(){
        for (int i=0; i<100; i++){
            System.out.println("Iteration "+i+" Success");
            if (!LAB6_DSElGamal.checkForTest()){
                Assert.fail();
            }
        }
    }
}
