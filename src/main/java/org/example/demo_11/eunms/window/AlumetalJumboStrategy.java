package org.example.demo_11.eunms.window;

import org.example.demo_11.model.Price;

public class AlumetalJumboStrategy implements WindowPriceStrategy {
    private final Price price;

    public AlumetalJumboStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getWindowPrices().getAlumetalJumboMaterials(),
                price.getWindowPrices().getAlumetalJumboLabor());
    }

    private Long safeAdd(Long materials, Long labor) {
        long m = materials != null ? materials : 0L;
        long l = labor != null ? labor : 0L;
        return m + l;
    }
}