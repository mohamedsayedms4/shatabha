package org.example.demo_11.eunms.base;

import org.example.demo_11.model.Price;

public class FloorStandingStrategy implements BasePriceStrategy {

    private final Price price;

    public FloorStandingStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        // خد القيم من الـ BathroomPrices الـ Embedded
        Long materials = price.getBathroomPrices().getBasefloorStandingMaterials();
        Long labor = price.getBathroomPrices().getBasefloorStandingLabor();

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