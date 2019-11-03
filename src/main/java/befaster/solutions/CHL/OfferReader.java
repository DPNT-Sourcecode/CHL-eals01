package befaster.solutions.CHL;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class OfferReader {

    public List<Offer> readOffers() {
        return asList(
                new Offer(singletonList(new OfferRequirement("A", 5)), 50),
                new Offer(singletonList(new OfferRequirement("A", 3)), 20),
                new Offer(asList(new OfferRequirement("E", 2), new OfferRequirement("B", 1)), 30),
                new Offer(singletonList(new OfferRequirement("B", 2)), 15),
                new Offer(singletonList(new OfferRequirement("F", 3)), 10)
        );
    }

}




