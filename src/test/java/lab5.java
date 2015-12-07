import org.junit.Assert;
import org.junit.Test;

/**
 * Created by anna on 12/7/15.
 */
public class lab5 {
    @Test
    public void test_lab4(){
        for (int i=0; i<100; i++){
            System.out.println("Iteration "+i+" Success");
            if (!LAB5_InverseElem.check4Test()){
                Assert.fail();
            }
        }
    }
}
