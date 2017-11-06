package test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import main.java.ua.training.Model;

/**
 * Created by Влада on 04.11.2017.
 */
public class ModelTest {

    private static Model model;

    @BeforeClass
    public static void Init() {
        model = new Model();
    }

    @Test
    public void testRand() {
        int rand;
        for (int i = 0; i < 10000; i++) {
            model.makeInterval(0, 100);
            model.rand();
            rand = model.getThoughtNumber();
            if (rand < 0 || rand > 100) {
                Assert.fail();
            }
        }
    }

    @Test
    public void testMinMax() {
        int rand, minMax = 0;
        for (int i = 0; i < 10000; i++) {
            model.makeInterval(0, 100);
            model.rand();
            rand = model.getThoughtNumber();
            if (rand == 0 || rand == 100) {
                minMax++;
            }
        }
        Assert.assertTrue(minMax > 0);
    }

    @Test
    public void testValueInInterval() {
        model.makeInterval(0, 100);
        Assert.assertTrue(!model.isValueInInterval(-15));
        Assert.assertTrue(!model.isValueInInterval(150));
        Assert.assertTrue(model.isValueInInterval(15));

    }

    @Test
    public void testInputEqualsThoughtNumber() {
        int rand = 50;
        for(int i = 0; i< 10000; i++) {
            model.makeInterval(0, 100);
            model.rand();
            if (rand < model.getThoughtNumber()) {
                Assert.assertTrue(model.isInputEqualsThoughtNumber(rand) == 1);
            } else if (rand > model.getThoughtNumber()) {
                Assert.assertTrue(model.isInputEqualsThoughtNumber(rand) == -1);
            } else {
                Assert.assertTrue(model.isInputEqualsThoughtNumber(rand) == 0);
            }
        }
    }
}
