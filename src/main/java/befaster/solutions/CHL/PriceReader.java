package befaster.solutions.CHL;

public class PriceReader {

    public int readPrice(String sku) {
        switch (sku) {
            case "A": return 50;
            case "B": return 30;
            case "C": return 20;
            case "D": return 15;
            default: throw new IllegalArgumentException();
        }
    }

    public boolean productExists(String sku) {
        try {
            readPrice(sku);
            return true;
        } catch(IllegalArgumentException ex) {
            return false;
        }
    }

}
