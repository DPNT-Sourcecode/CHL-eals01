package befaster.solutions.CHL;

import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

public class PriceCalculator {

    private final PriceReader priceReader;
    private final OfferReader offerReader;
    private final SingleOfferDiscountCalculator discountCalculator;

    public PriceCalculator(PriceReader priceReader, OfferReader offerReader, SingleOfferDiscountCalculator discountCalculator) {
        this.priceReader = priceReader;
        this.offerReader = offerReader;
        this.discountCalculator = discountCalculator;
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
        return offerReader.readOffers()
                .stream()
                .mapToInt(offer -> discountCalculator.calculateDiscount(offer, skusToCounts))
                .sum();
    }

}

