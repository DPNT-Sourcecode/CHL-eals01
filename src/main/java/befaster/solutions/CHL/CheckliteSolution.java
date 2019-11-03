package befaster.solutions.CHL;

public class CheckliteSolution {

    private final PriceReader priceReader = new PriceReader() ;

    public Integer checklite(String skus) {
        int total = 0;
        for (String sku : skus.split("")) {
            total += priceReader.readPrice(sku);
        }
        return total;
    }

}

