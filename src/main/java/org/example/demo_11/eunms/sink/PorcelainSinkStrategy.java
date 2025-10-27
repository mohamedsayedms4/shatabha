package org.example.demo_11.eunms.sink;

import org.example.demo_11.model.Price;

public class PorcelainSinkStrategy implements SinkPriceStrategy {

    @Override
    public Long calculatePrice(Price price) {
        return safeAdd(price.getBathroomPrices().getSinkPorcelainMaterials(),
                price.getBathroomPrices().getSinkPorcelainLabor());
    }

    private Long safeAdd(Long materials, Long labor) {
        long m = materials != null ? materials : 0L;
        long l = labor != null ? labor : 0L;
        return m + l;
    }
}
