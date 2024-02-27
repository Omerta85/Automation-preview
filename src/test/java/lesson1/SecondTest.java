package lesson1;

import base.config.BaseTest;
import org.testng.annotations.*;

public class SecondTest extends BaseTest {
//    @BeforeMethod
//    public void beforeMethodTest(){
//        System.out.println("This method works before every methods");
//    }
    @Test
    public void test(){
        System.out.println("Our second test");
    }
}
