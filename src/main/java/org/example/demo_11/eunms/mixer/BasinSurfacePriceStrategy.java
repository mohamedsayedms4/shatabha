package org.example.demo_11.eunms.mixer;


import org.example.demo_11.model.Price;

public class BasinSurfacePriceStrategy implements MixerPriceStrategy {

    private final Price price;

    public BasinSurfacePriceStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getBathroomPrices().getBasinSurfaceMaterials(), price.getBathroomPrices().getBasinSurfaceLabor());
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
