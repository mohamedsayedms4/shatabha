package org.example.demo_11.eunms.mixer;

import org.example.demo_11.model.Price;

public class ShowerConcealed2PriceStrategy implements MixerPriceStrategy {

    private final Price price;

    public ShowerConcealed2PriceStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getBathroomPrices().getShowerConcealed2Materials(), price.getBathroomPrices().getShowerConcealed2Labor(),
                price.getBathroomPrices().getBuriedShowerMixer2OutletLabor(), price.getBathroomPrices().getBuriedShowerMixer2OutletMaterials());
    }

    private Long safeAdd(Long... values) {
        long sum = 0L;
        for (Long val : values) {
            sum += (val != null ? val : 0L);
        }
        return sum;
    }
}

// نفس الفكرة لكل نوع خلاط:
// BasinConcealedPriceStrategy
// ShowerSurfacePriceStrategy
// ShowerConcealedPriceStrategy
// ShowerSmartPriceStrategy
// ShattafSurfacePriceStrategy
// ShattafConcealedPriceStrategy
