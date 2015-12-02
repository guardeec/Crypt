import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guardeec on 01.12.15.
 */
public class lab8 {
    @Test
    public void test_lab8(){
        for (int i=0; i<100; i++){
            System.out.println("Iteration "+i+" Success");
            if (!LAB8_Chaum.checkForTest()){
                Assert.fail();
            }
        }
    }
}
