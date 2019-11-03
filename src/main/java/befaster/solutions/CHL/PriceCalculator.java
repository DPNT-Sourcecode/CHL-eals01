package befaster.solutions.CHL;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toMap;

public class PriceCalculator {

    private final PriceReader priceReader;
    private final OfferReader offerReader;

    public PriceCalculator(PriceReader priceReader, OfferReader offerReader) {
        this.priceReader = priceReader;
        this.offerReader = offerReader;
    }

    public int calculateTotal(String skus) {
        Map<String, Integer> skusToCounts = skus.chars()
                .mapToObj(String::valueOf)
                .collect(groupingBy(identity(), reducing(0, e -> 1, Integer::sum)));

        int total = 0;
        for (Entry<String, Integer> skuToCount : skusToCounts.entrySet()) {
            String sku = skuToCount.getKey();
            int count = skuToCount.getValue();

            Offer offer = offerReader.readOfferForItem(sku);

            if (offer == null) {
                total += count * priceReader.readPrice(sku);
            } else {
                total += count / offer.getCount() * offer.getPrice();
            }
        }

        return total;
    }

}


