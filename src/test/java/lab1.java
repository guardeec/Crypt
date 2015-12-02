import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guardeec on 30.11.15.
 */
public class lab1 {

    @Test
    public void test_lab1(){
        for (int i=0; i<100; i++){
            System.out.println("Iteration "+i+" Success");
            if (!LAB1_DiffieHellman.checkForTest()){
                Assert.fail();
            }
        }
    }
}
