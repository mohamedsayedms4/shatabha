package org.example.demo_11.eunms.window;


import org.example.demo_11.model.Price;

public class AlumetalPsStrategy implements WindowPriceStrategy {
    private final Price price;

    public AlumetalPsStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return price.getWindowPrices().getAlumetalPsMaterials() + price.getWindowPrices().getAlumetalPsLabor();
    }
}