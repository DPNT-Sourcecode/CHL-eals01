package befaster.solutions.CHL;

import org.junit.Test;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;

public class CheckliteSolutionTest {

    private final CheckliteSolution solution = new CheckliteSolution();

    @Test
    public void returnsTotalPriceOfProductsWithoutOffers() {
        int total = solution.checklite("ABCD");

        assertThat(total, sameBeanAs(115));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionForUnknownSku() {
        solution.checklite("X");
    }

}

