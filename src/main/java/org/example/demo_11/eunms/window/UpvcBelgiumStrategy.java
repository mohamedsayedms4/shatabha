package org.example.demo_11.eunms.window;

import org.example.demo_11.model.Price;

public class UpvcBelgiumStrategy implements WindowPriceStrategy {
    private final Price price;

    public UpvcBelgiumStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return price.getWindowPrices().getUpvcBelgiumMaterials() + price.getWindowPrices().getUpvcBelgiumLabor();
    }
}