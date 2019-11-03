package befaster.solutions.CHL;

public class CheckliteSolution {

    private final PriceReader priceReader = new PriceReader() ;
    private final OfferReader offerReader = new OfferReader();
    private final SingleOfferDiscountCalculator discountCalculator = new SingleOfferDiscountCalculator();

    private final PriceCalculator calculator = new PriceCalculator(priceReader, offerReader, discountCalculator);

    public Integer checklite(String skus) {
        return calculator.calculateTotal(skus);
    }

}
