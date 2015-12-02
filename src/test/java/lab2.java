import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guardeec on 30.11.15.
 */
public class lab2 {

    @Test
    public void test_lab2(){
        for (int i=0; i<100; i++){
            System.out.println("Iteration "+i+" Success");
            if (!LAB2_RSA.checkForTest()){
                Assert.fail();
            }
        }
    }
}
