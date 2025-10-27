package org.example.demo_11.eunms.shutter;

import org.example.demo_11.model.Price;

public class ShutterWeatherResistantStrategy implements ShutterPriceStrategy {
    private final Price price;

    public ShutterWeatherResistantStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return price.getShutterPrices().getShutterWeatherResistantMaterials() + price.getShutterPrices().getShutterWeatherResistantLabor();
    }
}