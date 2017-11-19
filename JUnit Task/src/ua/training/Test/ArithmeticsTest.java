package ua.training.Test;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import ua.training.Calculation.Arithmetics;

/**
 * Created by Влада on 01.11.2017.
 */
public class ArithmeticsTest {

        private static Arithmetics arithmetics;

    @Rule
    public final ExpectedException except = ExpectedException.none();

    @Rule
    public final Timeout time = new Timeout(1000);


        @BeforeClass
        public static void runT(){
            arithmetics = new Arithmetics();
        }

        @Test
        public void testAdd() {
            double result = arithmetics.add(5, 5);
            Assert.assertEquals(result, 10, 0);
            //Assert.assertSame(result, 10.0); ERROR
            //Assert.assertTrue("err",result == 10);
            //Assert.assertFalse("err",result != 10);
            //if(result != 10) Assert.fail();
            //Assert.assertNull();
            //Assert.assertNotNull
        }

        @Ignore
        @Test
        public void testDeduct() {
            double result = arithmetics.deduct(5, 5);
            Assert.assertEquals(result, 0, 0);
        }

        @Test
        public void testMult() {
            double result = arithmetics.mult(5, 5);
            Assert.assertEquals(result, 25, 0);
        }

        @Test
        public void testDiv() {
            double result = arithmetics.div(5, 5);
            Assert.assertEquals(result, 1, 0);
        }

        //@Test(expected = ArithmeticException.class)
        @Test
        public void testDivExcep() {
            except.expect(ArithmeticException.class);
            arithmetics.div(5, 0);
        }

        //@Test(timeout = 1000)
        @Test
        public void TestTimeout(){
            while (true) {}
            //arithmetics.div(5.0, 0.0);
        }


}
