package befaster.solutions.CHL;

public class OfferReader {

    public Offer readOfferForItem(String sku) {
        switch (sku) {
            case "A": return new Offer(3, 130);
            case "B": return new Offer(2, 45);
            default: throw new IllegalArgumentException();
        }
    }

}

