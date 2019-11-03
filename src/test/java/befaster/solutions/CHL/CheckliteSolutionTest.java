package befaster.solutions.CHL;

import org.junit.Test;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;

public class CheckliteSolutionTest {

    private final CheckliteSolution solution = new CheckliteSolution();

    @Test
    public void returnsTotalPriceOfProductsWithoutOffers() {
        int total = solution.checklite("ABCDE");

        assertThat(total, sameBeanAs(155));
    }

    @Test
    public void returnsMinusOneForIllegalInput() {
        int total = solution.checklite("a");

        assertThat(total, sameBeanAs(-1));
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

    @Test
    public void returnsTotalPriceForItemWithOfferWhenCountIsNotMultiple() {
        int total = solution.checklite("AAAA");

        assertThat(total, sameBeanAs(130 + 50));
    }

    @Test
    public void buyingTwoItemsEGivesOneItemBForFree() {
        int total = solution.checklite("EEB");

        assertThat(total, sameBeanAs(80));

    }

}
