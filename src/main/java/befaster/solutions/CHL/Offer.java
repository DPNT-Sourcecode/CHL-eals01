package befaster.solutions.CHL;

public class Offer {

    private final OfferRequirement requirement;
    private final int discount;

    public Offer(OfferRequirement requirement, int discount) {
        this.requirement = requirement;
        this.discount = discount;
    }

    public OfferRequirement getRequirement() {
        return requirement;
    }

    public int getDiscount() {
        return discount;
    }

}

