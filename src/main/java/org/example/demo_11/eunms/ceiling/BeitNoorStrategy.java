package org.example.demo_11.eunms.ceiling;

import org.example.demo_11.model.Price;

public class BeitNoorStrategy implements CeilingPriceStrategy {
    private final Price price;

    public BeitNoorStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice(Double area, Double perimeter) {
        // خد القيم من الـ CeilingPrices الـ Embedded
        Long materials = price.getCeilingPrices().getBeitNoorMaterials();
        Long labor = price.getCeilingPrices().getBeitNoorLabor();
        Long backLed = price.getLightingPrices().getBackLedHiddenLighting();

        Long basePrice = safeAdd(materials, labor);
        return (long)(basePrice * perimeter) + backLed;
    }

    private Long safeAdd(Long materials, Long labor) {
        long m = materials != null ? materials : 0L;
        long l = labor != null ? labor : 0L;
        return m + l;
    }
}