package org.example.demo_11.eunms.mixer;


import org.example.demo_11.model.Price;

public class ShattafHangingPriceStrategy implements MixerPriceStrategy {

    private final Price price;

    public ShattafHangingPriceStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getBathroomPrices().getShattafHangingLabor(), price.getBathroomPrices().getShattafHangingMaterials(),
                price.getBathroomPrices().getWallHungConcealedLabor(),price.getBathroomPrices().getWallHungConcealedMaterials());
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
