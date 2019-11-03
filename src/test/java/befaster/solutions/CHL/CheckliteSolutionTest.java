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

    @Test
    public void returnsTotalPriceForItemAWithOffer() {
        int total = solution.checklite("AAA");

        assertThat(total, sameBeanAs(130));
    }

    @Test
    public void returnsTotalPriceForItemBWithOffer() {
        int total = solution.checklite("BB");

        assertThat(total, sameBeanAs(45));
    }

}


