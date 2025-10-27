package org.example.demo_11.eunms.door;

import org.example.demo_11.model.Price;

public class NoneDoorStrategy implements DoorPriceStrategy {

    private final Price price;

    public NoneDoorStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return 0L; // لا يوجد سعر للخيار NONE
    }
}
