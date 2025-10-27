package org.example.demo_11.eunms.mixer;

import org.example.demo_11.model.Price;

public class ShattafSurfacePriceStrategy implements MixerPriceStrategy {

    private final Price price;

    public ShattafSurfacePriceStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getBathroomPrices().getShattafSurfaceMaterials(), price.getBathroomPrices().getShattafSurfaceLabor());
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
