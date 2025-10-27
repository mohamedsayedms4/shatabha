package org.example.demo_11.eunms.mixer;


import org.example.demo_11.model.Price;

public class ShattafConcealedPriceStrategy implements MixerPriceStrategy {

    private final Price price;

    public ShattafConcealedPriceStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getBathroomPrices().getShattafConcealedLabor(), price.getBathroomPrices().getShattafConcealedMaterials(),
                price.getBathroomPrices().getBuriedShattafMixerLabor(),price.getBathroomPrices().getBuriedShattafMixerMaterials());
    }

    private Long safeAdd(Long... values) {
        long sum = 0L;
        for (Long val : values) {
            sum += (val != null ? val : 0L);
        }
        return sum;
    }}

// نفس الفكرة لكل نوع خلاط:
// BasinConcealedPriceStrategy
// ShowerSurfacePriceStrategy
// ShowerConcealedPriceStrategy
// ShowerSmartPriceStrategy
// ShattafSurfacePriceStrategy
// ShattafConcealedPriceStrategy
