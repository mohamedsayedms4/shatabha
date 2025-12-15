package org.example.demo_11.eunms.ceiling;

import org.example.demo_11.model.Price;

public class ShadowGapStrategy implements CeilingPriceStrategy {
    private final Price price;

    public ShadowGapStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice(Double area, Double perimeter) {
        Long materials = price.getCeilingPrices().getShadowGapMaterials();
        Long labor = price.getCeilingPrices().getShadowGapLabor();
        Long band51Materials = price.getCeilingPrices().getBand51Materials();
        Long band51Labor = price.getCeilingPrices().getBand51Labor();

        Long shadowGapPrice = safeAdd(materials, labor);
        Long band51Price = safeAdd(band51Materials, band51Labor);

        return shadowGapPrice * perimeter.longValue() + band51Price;
    }

    private Long safeAdd(Long materials, Long labor) {
        long m = materials != null ? materials : 0L;
        long l = labor != null ? labor : 0L;
        return m + l;
    }
}