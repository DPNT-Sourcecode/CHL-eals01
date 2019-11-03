package befaster.solutions.CHL;

import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

public class PriceCalculator {

    private final PriceReader priceReader;
    private final OfferReader offerReader;

    public PriceCalculator(PriceReader priceReader, OfferReader offerReader) {
        this.priceReader = priceReader;
        this.offerReader = offerReader;
    }

    public int calculateTotal(String skus) {
        Map<String, Integer> skusToCounts = skus.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(groupingBy(identity(), reducing(0, e -> 1, Integer::sum)));

        for (String sku : skusToCounts.keySet()) {
            if (!priceReader.productExists(sku)) {
                return -1;
            }
        }

        int total = skusToCounts.entrySet().stream()
                .mapToInt(entry -> priceReader.readPrice(entry.getKey()) * entry.getValue())
                .sum();

        total -= calculateDiscounts(skusToCounts);

        return total;
    }

    private int calculateDiscounts(Map<String, Integer> skusToCounts) {
        int totalDiscount = 0;

        List<Offer> offers = offerReader.readOffers();
        for (Offer offer : offers) {
            while(canApplyDiscount(skusToCounts, offer.getRequirements())) {
                totalDiscount += offer.getDiscount();

                for (OfferRequirement requirement : offer.getRequirements()) {
                    String sku = requirement.getSku();
                    skusToCounts.put(sku, skusToCounts.get(sku) - requirement.getCount());
                }
            }
        }

        return totalDiscount;
    }

    private static boolean canApplyDiscount(Map<String, Integer> skusToCounts, List<OfferRequirement> requirements) {
        for (OfferRequirement requirement : requirements) {
            if (!skusToCounts.containsKey(requirement.getSku())) {
                return false;
            }
            if (skusToCounts.get(requirement.getSku()) < requirement.getCount()) {
                return false;
            }
        }
        return true;
    }

}
