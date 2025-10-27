package org.example.demo_11.eunms.mixer;

import org.example.demo_11.model.Price;

public class ShowerSmartPriceStrategy implements MixerPriceStrategy {

    private final Price price;

    public ShowerSmartPriceStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getBathroomPrices().getShowerSmartLabor(), price.getBathroomPrices().getShowerSmartMaterials());
    }

    private Long safeAdd(Long a, Long b) {
        return (a != null ? a : 0L) + (b != null ? b : 0L);
    }
}

// نفس الفكرة لكل نوع خلاط:
// BasinConcealedPriceStrategy
// ShowerSurfacePriceStrategy
// ShowerConcealedPriceStrategy
// ShowerSmartPriceStrategy
// ShattafSurfacePriceStrategy
// ShattafConcealedPriceStrategy
