package org.example.demo_11.eunms.window;

import org.example.demo_11.model.Price;

public class UpvcTurkeyStrategy implements WindowPriceStrategy {
    private final Price price;

    public UpvcTurkeyStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return price.getWindowPrices().getUpvcTurkeyMaterials() + price.getWindowPrices().getUpvcTurkeyLabor();
    }
}