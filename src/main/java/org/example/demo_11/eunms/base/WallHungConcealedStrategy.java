package org.example.demo_11.eunms.base;

import org.example.demo_11.model.Price;

public class WallHungConcealedStrategy implements BasePriceStrategy {

    private final Price price;

    public WallHungConcealedStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        Long materials = price.getBathroomPrices().getBaseWallHungConcealedMaterials();
        Long labor = price.getBathroomPrices().getBaseWallHungConcealedLabor();
        Long boxMaterials = price.getBathroomPrices().getBaseWallHungConcealedBoxMaterials();
        Long boxLabor = price.getBathroomPrices().getBaseWallHungConcealedBoxLabor();

        return safeAdd(materials, labor, boxMaterials, boxLabor);
    }

    private Long safeAdd(Long... values) {
        long sum = 0L;
        for (Long val : values) {
            sum += (val != null ? val : 0L);
        }
        return sum;
    }
}