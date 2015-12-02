import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guardeec on 01.12.15.
 */
public class lab7 {
    @Test
    public void test_lab7(){
        for (int i=0; i<100; i++){
            System.out.println("Iteration "+i+" Success");
            if (!LAB7_DSRSA.checkForTest()){
                Assert.fail();
            }
        }
    }
}
