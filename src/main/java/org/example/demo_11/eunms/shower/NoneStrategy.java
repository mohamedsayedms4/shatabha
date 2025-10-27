package org.example.demo_11.eunms.shower;


import org.example.demo_11.model.Price;

public class NoneStrategy implements ShowerPriceStrategy {
    private final Price price;

    public NoneStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getBathroomPrices().getShowerNoneLabor(), price.getBathroomPrices().getShowerNoneMaterials());
    }

    private Long safeAdd(Long materials, Long labor) {
        long m = materials != null ? materials : 0L;
        long l = labor != null ? labor : 0L;
        return m + l;
    }
}
