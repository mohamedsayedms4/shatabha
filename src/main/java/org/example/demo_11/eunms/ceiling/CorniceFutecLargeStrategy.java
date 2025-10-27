package org.example.demo_11.eunms.ceiling;


import org.example.demo_11.model.Price;

public class CorniceFutecLargeStrategy implements CeilingPriceStrategy {
    private final Price price;

    public CorniceFutecLargeStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice(Double area, Double perimeter) {
        return safeAdd(price.getCeilingPrices().getCorniceFutecLargeMaterials(), price.getCeilingPrices().getCorniceFutecLargeLabor());
    }

    private Long safeAdd(Long materials, Long labor) {
        long m = materials != null ? materials : 0L;
        long l = labor != null ? labor : 0L;
        return m + l;
    }
}
