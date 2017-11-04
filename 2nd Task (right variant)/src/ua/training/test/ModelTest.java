package ua.training.test;

import org.junit.Assert;
import org.junit.Test;
import ua.training.Model;

/**
 * Created by Влада on 04.11.2017.
 */
public class ModelTest {

    @Test
    public void testRand() {
        Model model = new Model();
        model.makeInterval(0, 100);
        int rand;
        for (int i = 0; i < 10000; i++) {
            model.rand();
            rand = model.thoughtNumber;
            if (rand < 0 || rand > 100) {
                Assert.fail();
            }
        }
    }

    @Test
    public void testMinMax() {
        Model model = new Model();
        model.makeInterval(0, 100);
        int rand, minMax = 0;
        for (int i = 0; i < 10000; i++) {
            model.rand();
            rand = model.thoughtNumber;
            if (rand == 0 || rand == 100) {
                minMax++;
            }
        }
        Assert.assertTrue(minMax > 0);
    }
}
