package befaster.solutions.CHL;

public class CheckliteSolution {

    private final PriceReader priceReader = new PriceReader() ;
    private final OfferReader offerReader = new OfferReader();

    private final PriceCalculator calculator = new PriceCalculator(priceReader, offerReader);

    public Integer checklite(String skus) {
        return calculator.calculateTotal(skus);
    }

}


