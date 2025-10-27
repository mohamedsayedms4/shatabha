package org.example.demo_11.eunms.door;

import org.example.demo_11.model.Price;

public class CustomMadeDoorStrategy implements DoorPriceStrategy {

    private final Price price;

    public CustomMadeDoorStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getDoorPrices().getCustomMadeDoorMaterials(), price.getDoorPrices().getCustomMadeDoorLabor());
    }

    private Long safeAdd(Long v1, Long v2) {
        long a = (v1 != null) ? v1 : 0L;
        long b = (v2 != null) ? v2 : 0L;
        return a + b;
    }
}
