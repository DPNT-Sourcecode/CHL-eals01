package befaster.solutions.CHL;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

/**
 * This class simulates database reader. In real life, offers would be defined by administrators of the system,
 * not by developers, and they can be changed frequently. Therefore offers from round 4 do not have test coverage.
 */
public class OfferReader {

    public List<Offer> readOffers() {
        return asList(
                new Offer(singletonList(new OfferRequirement("A", 5)), 50),
                new Offer(singletonList(new OfferRequirement("A", 3)), 20),
                new Offer(asList(new OfferRequirement("E", 2), new OfferRequirement("B", 1)), 30),
                new Offer(singletonList(new OfferRequirement("B", 2)), 15),
                new Offer(singletonList(new OfferRequirement("F", 3)), 10),
                new Offer(singletonList(new OfferRequirement("H", 10)), 20),
                new Offer(singletonList(new OfferRequirement("H", 5)), 5),
                new Offer(singletonList(new OfferRequirement("K", 2)), 10),
                new Offer(asList(new OfferRequirement("N", 3), new OfferRequirement("M", 1)), 15),
                new Offer(singletonList(new OfferRequirement("P", 5)), 50),
                new Offer(asList(new OfferRequirement("R", 3), new OfferRequirement("Q", 1)), 30),
                new Offer(singletonList(new OfferRequirement("Q", 3)), 80),
                new Offer(singletonList(new OfferRequirement("U", 4)), 40),
                new Offer(singletonList(new OfferRequirement("V", 3)), 20),
                new Offer(singletonList(new OfferRequirement("V", 2)), 10)
        );
    }

}

