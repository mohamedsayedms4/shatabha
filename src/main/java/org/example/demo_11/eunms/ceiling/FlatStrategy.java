package org.example.demo_11.eunms.ceiling;

import org.example.demo_11.model.Price;

public class FlatStrategy implements CeilingPriceStrategy {
    private final Price price;

    public FlatStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice(Double area, Double perimeter) {
        Long materials = price.getCeilingPrices().getFlatMaterials();
        Long labor = price.getCeilingPrices().getFlatLabor();


        Long basePrice = safeAdd(materials, labor);
        return (long)(basePrice * area) ;
    }

    private Long safeAdd(Long materials, Long labor) {
        long m = materials != null ? materials : 0L;
        long l = labor != null ? labor : 0L;
        return m + l;
    }
}