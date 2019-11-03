package befaster.solutions.CHL;

import java.util.Map;
import java.util.Map.Entry;

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
        Map<String, Integer> skusToCounts = skus.toUpperCase().chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(groupingBy(identity(), reducing(0, e -> 1, Integer::sum)));

        for (String sku : skusToCounts.keySet()) {
            if (!priceReader.productExists(sku)) {
                return -1;
            }
        }

        int total = 0;
        for (Entry<String, Integer> skuToCount : skusToCounts.entrySet()) {
            String sku = skuToCount.getKey();
            int count = skuToCount.getValue();
            int price = priceReader.readPrice(sku);

            Offer offer = offerReader.readOfferForItem(sku);

            if (offer == null) {
                total += count * price;
            } else {
                total += count / offer.getCount() * offer.getPrice() + count % offer.getCount() * price;
            }
        }

        return total;
    }

}






