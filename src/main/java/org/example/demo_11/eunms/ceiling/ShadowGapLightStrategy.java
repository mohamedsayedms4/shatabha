package org.example.demo_11.eunms.ceiling;


import org.example.demo_11.model.Price;

public class ShadowGapLightStrategy implements CeilingPriceStrategy {
    private final Price price;

    public ShadowGapLightStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice(Double area, Double perimeter) {
        Long shadowGap = safeAdd(price.getCeilingPrices().getShadowGapLightMaterials(), price.getCeilingPrices().getShadowGapLightLabor() );
        return (long) (shadowGap * perimeter.longValue() + area*price.getCeilingPrices().getBand51());
    }

    private Long safeAdd(Long materials, Long labor) {
        long m = materials != null ? materials : 0L;
        long l = labor != null ? labor : 0L;
        return m + l;
    }
}
