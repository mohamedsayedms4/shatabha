package org.example.demo_11.eunms.shutter;

import org.example.demo_11.model.Price;

public class ShutterProtectionStrategy implements ShutterPriceStrategy {
    private final Price price;

    public ShutterProtectionStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return price.getShutterPrices().getShutterProtectionMaterials() + price.getShutterPrices().getShutterProtectionLabor();
    }
}