package org.example.demo_11.eunms.window;

import org.example.demo_11.model.Price;

public class AlumetalJumpoStrategy implements WindowPriceStrategy {
    private final Price price;

    public AlumetalJumpoStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return price.getWindowPrices().getAlumetalJumpoMaterials() + price.getWindowPrices().getAlumetalJumpoLabor();
    }
}