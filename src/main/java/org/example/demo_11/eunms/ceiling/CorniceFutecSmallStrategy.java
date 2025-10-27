package org.example.demo_11.eunms.ceiling;


import org.example.demo_11.model.Price;

public class CorniceFutecSmallStrategy implements CeilingPriceStrategy {
    private final Price price;

    public CorniceFutecSmallStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice(Double area, Double perimeter) {
        return safeAdd(price.getCeilingPrices().getCorniceFutecSmallMaterials(), price.getCeilingPrices().getCorniceFutecSmallLabor());
    }

    private Long safeAdd(Long materials, Long labor) {
        long m = materials != null ? materials : 0L;
        long l = labor != null ? labor : 0L;
        return m + l;
    }
}
