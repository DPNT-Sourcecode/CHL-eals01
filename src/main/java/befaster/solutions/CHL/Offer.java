package befaster.solutions.CHL;

import java.util.List;

public class Offer {

    private final List<OfferRequirement> requirements;
    private final int discount;

    public Offer(List<OfferRequirement> requirements, int discount) {
        this.requirements = requirements;
        this.discount = discount;
    }

    public List<OfferRequirement> getRequirements() {
        return requirements;
    }

    public int getDiscount() {
        return discount;
    }

}
