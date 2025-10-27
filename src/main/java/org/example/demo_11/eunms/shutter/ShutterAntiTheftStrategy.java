package org.example.demo_11.eunms.shutter;

import org.example.demo_11.model.Price;

public class ShutterAntiTheftStrategy implements ShutterPriceStrategy {
    private final Price price;

    public ShutterAntiTheftStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return price.getShutterPrices().getShutterAntiTheftMaterials() + price.getShutterPrices().getShutterAntiTheftLabor();
    }
}