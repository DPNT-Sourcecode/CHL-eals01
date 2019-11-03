package befaster.solutions.CHL;

import java.util.List;
import java.util.Map;

public class SingleOfferDiscountCalculator {

    public int calculateDiscount(Offer offer, Map<String, Integer> skusToCounts) {
        int totalDiscount = 0;
        while(canApplyDiscount(skusToCounts, offer.getRequirements())) {
            totalDiscount += offer.getDiscount();

            for (OfferRequirement requirement : offer.getRequirements()) {
                String sku = requirement.getSku();
                skusToCounts.put(sku, skusToCounts.get(sku) - requirement.getCount());
            }
        }
        return totalDiscount;
    }

    private static boolean canApplyDiscount(Map<String, Integer> skusToCounts, List<OfferRequirement> requirements) {
        for (OfferRequirement requirement : requirements) {
            if (!skusToCounts.containsKey(requirement.getSku())) {
                return false;
            }
            if (skusToCounts.get(requirement.getSku()) < requirement.getCount()) {
                return false;
            }
        }
        return true;
    }

}

