package org.example.demo_11.eunms.mixer;

import org.example.demo_11.model.Price;

public class ShowerConcealedTwoOutletPriceStrategy implements MixerPriceStrategy {

    private final Price price;

    public ShowerConcealedTwoOutletPriceStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getBathroomPrices().getShowerConcealedTwoOutletMaterials(),
                price.getBathroomPrices().getShowerConcealedTwoOutletLabor(),
                price.getBathroomPrices().getBuriedShowerMixerTwoOutletLabor(),
                price.getBathroomPrices().getBuriedShowerMixerTwoOutletMaterials());
    }

    private Long safeAdd(Long... values) {
        long sum = 0L;
        for (Long val : values) {
            sum += (val != null ? val : 0L);
        }
        return sum;
    }
}