package org.example.demo_11.eunms.base;

import org.example.demo_11.model.Price;

public class FloorStandingStrategy implements BasePriceStrategy {

    private final Price price;

    public FloorStandingStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        Long materials = price.getBathroomPrices().getBaseFloorStandingMaterials();
        Long labor = price.getBathroomPrices().getBaseFloorStandingLabor();

        return safeAdd(materials, labor);
    }

    private Long safeAdd(Long... values) {
        long sum = 0L;
        for (Long val : values) {
            sum += (val != null ? val : 0L);
        }
        return sum;
    }
}