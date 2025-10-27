package org.example.demo_11.eunms.ceiling;

import org.example.demo_11.model.Price;

public class ShadowGapStrategy implements CeilingPriceStrategy {
    private final Price price;

    public ShadowGapStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice(Double area, Double perimeter) {
        // خد القيم من الـ CeilingPrices الـ Embedded
        Long materials = price.getCeilingPrices().getShadowGapMaterials();
        Long labor = price.getCeilingPrices().getShadowGapLabor();
        Long band51 = price.getCeilingPrices().getBand51();

        Long shadowGap = safeAdd(materials, labor);
        return shadowGap * perimeter.longValue() + band51;
    }

    private Long safeAdd(Long materials, Long labor) {
        long m = materials != null ? materials : 0L;
        long l = labor != null ? labor : 0L;
        return m + l;
    }
}