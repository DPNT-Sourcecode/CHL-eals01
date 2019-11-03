package befaster.solutions.CHL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static java.util.Arrays.asList;

@RunWith(Parameterized.class)
public class PriceCalculatorTest {

    @Parameters
    public static Collection<Object[]> data() {
        return asList(new Object[][] {
                { 0, 0 },
                { 1, 1 },
        });
    }

    private final String sku;
    private final int expectedPrice;

    public PriceCalculatorTest(String sku, int expectedPrice) {
        this.sku = sku;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void test() {
        assertEquals(fExpected, Fibonacci.compute(fInput));
    }
}
