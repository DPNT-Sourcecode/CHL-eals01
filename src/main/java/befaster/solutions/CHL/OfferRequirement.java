package befaster.solutions.CHL;

public class OfferRequirement {

    private final int count;
    private final int price;

    public OfferRequirement(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

}
