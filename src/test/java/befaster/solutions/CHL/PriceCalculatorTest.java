package befaster.solutions.CHL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static java.util.Arrays.asList;

@RunWith(Parameterized.class)
public class PriceCalculatorTest {

    @Parameters(name = "item {0}")
    public static Collection<Object[]> data() {
        return asList(new Object[][]{
                {"A", 50},
                {"B", 30},
                {"C", 20},
                {"D", 15},
                {"E", 40},
                {"F", 10},
                {"G", 20},
                {"H", 10},
                {"I", 35},
                {"J", 60},
                {"K", 80},
                {"L", 90},
                {"M", 15},
                {"N", 40},
                {"O", 10},
                {"P", 50},
                {"Q", 30},
                {"R", 50},
                {"S", 30},
                {"T", 20},
                {"U", 40},
                {"V", 50},
                {"W", 20},
                {"X", 90},
                {"Y", 10},
                {"Z", 50}
        });
    }

    private final String sku;
    private final int expectedPrice;

    private final PriceReader priceReader = new PriceReader();

    public PriceCalculatorTest(String sku, int expectedPrice) {
        this.sku = sku;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void exists() {
        assertThat(priceReader.productExists(sku), sameBeanAs(true));
    }

    @Test
    public void hasPrice() {
        assertThat(priceReader.readPrice(sku), sameBeanAs(expectedPrice));
    }

}
