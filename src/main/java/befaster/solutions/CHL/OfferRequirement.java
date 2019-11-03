package befaster.solutions.CHL;

public class OfferRequirement {

    private final String sku;
    private final int count;

    public OfferRequirement(String sku, int count) {
        this.sku = sku;
        this.count = count;
    }

    public String getSku() {
        return sku;
    }

    public int getCount() {
        return count;
    }

}
