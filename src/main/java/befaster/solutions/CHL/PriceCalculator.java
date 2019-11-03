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
            String sku = offer.getRequirements().getSku();
            int requiredCount = offer.getRequirements().getCount();
            int discount = offer.getDiscount();

            while (skusToCounts.containsKey(sku) && skusToCounts.get(sku) >= requiredCount) {
                totalDiscount += discount;
                skusToCounts.put(sku, skusToCounts.get(sku) - requiredCount);
            }
        }

        return totalDiscount;
    }

}
