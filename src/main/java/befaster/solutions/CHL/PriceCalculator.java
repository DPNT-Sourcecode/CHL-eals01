package befaster.solutions.CHL;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toMap;

public class PriceCalculator {

    private final PriceReader priceReader;
    private final OfferReader offerReader;

    public PriceCalculator(PriceReader priceReader, OfferReader offerReader) {
        this.priceReader = priceReader;
        this.offerReader = offerReader;
    }

    public int calculateTotal(String skus) {
        skus.chars()
                .mapToObj(String::valueOf)
                .collect(toMap(c -> c, 1));


        int total = 0;
        for (String sku : skus.split("")) {
            total += priceReader.readPrice(sku);
        }
        return total;
    }

}

