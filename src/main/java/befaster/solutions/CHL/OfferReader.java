package befaster.solutions.CHL;

import java.util.Arrays;
import java.util.List;

public class OfferReader {

    public List<Offer> readOffers() {
        return Arrays.asList(
                new Offer(new OfferRequirement("A", 3), 20),
                new Offer(new OfferRequirement("B", 2), 15)
        );
    }

}

