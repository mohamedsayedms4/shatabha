package org.example.demo_11.eunms.shower;

// استراتيجية لكل نوع


import org.example.demo_11.model.Price;

public class BathtubStrategy implements ShowerPriceStrategy {
    private final Price price;

    public BathtubStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getBathroomPrices().getBathtubMaterials(), price.getBathroomPrices().getBathtubLabor());
    }

    private Long safeAdd(Long materials, Long labor) {
        long m = materials != null ? materials : 0L;
        long l = labor != null ? labor : 0L;
        return m + l;
    }
}
