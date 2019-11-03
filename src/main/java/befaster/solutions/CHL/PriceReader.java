package befaster.solutions.CHL;

public class PriceReader {

    @SuppressWarnings("DuplicateBranchesInSwitch")
    public int readPrice(String sku) {
        switch (sku) {
            case "A": return 50;
            case "B": return 30;
            case "C": return 20;
            case "D": return 15;
            case "E": return 40;
            case "F": return 10;
            case "G": return 20;
            case "H": return 10;
            case "I": return 35;
            case "J": return 60;
            case "K": return 80;
            case "L": return 90;
            case "M": return 15;
            case "N": return 40;
            case "O": return 10;
            case "P": return 50;
            case "Q": return 30;
            case "R": return 50;
            case "S": return 30;
            case "T": return 20;
            case "U": return 40;
            case "V": return 50;
            case "W": return 20;
            case "X": return 90;
            case "Y": return 10;
            case "Z": return 50;
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
