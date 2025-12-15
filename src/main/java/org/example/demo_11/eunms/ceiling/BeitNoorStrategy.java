package org.example.demo_11.eunms.ceiling;

import org.example.demo_11.model.Price;

public class BeitNoorStrategy implements CeilingPriceStrategy {
    private final Price price;

    public BeitNoorStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice(Double area, Double perimeter) {
        Long materials = price.getCeilingPrices().getBeitNoorMaterials();
        Long labor = price.getCeilingPrices().getBeitNoorLabor();
        Long backLedMaterials = price.getLightingPrices().getBackLedHiddenLightingMaterials();
        Long backLedLabor = price.getLightingPrices().getBackLedHiddenLightingLabor();

        Long basePrice = safeAdd(materials, labor);
        Long backLedPrice = safeAdd(backLedMaterials, backLedLabor);

        return (long)(basePrice * perimeter) + backLedPrice;
    }

    private Long safeAdd(Long materials, Long labor) {
        long m = materials != null ? materials : 0L;
        long l = labor != null ? labor : 0L;
        return m + l;
    }
}