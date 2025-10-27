package org.example.demo_11.eunms.mixer;


import org.example.demo_11.model.Price;

public class BasinConcealedPriceStrategy implements MixerPriceStrategy {

    private final Price price;

    public BasinConcealedPriceStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getBathroomPrices().getBasinConcealedMaterials(), price.getBathroomPrices().getBasinConcealedLabor(),
                price.getBathroomPrices().getBuriedSinkMixerMaterials(),
                price.getBathroomPrices().getBuriedSinkMixerLabor() );
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
