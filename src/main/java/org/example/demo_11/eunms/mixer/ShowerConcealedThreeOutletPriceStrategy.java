package org.example.demo_11.eunms.mixer;
import org.example.demo_11.model.Price;

public class ShowerConcealedThreeOutletPriceStrategy implements MixerPriceStrategy {

    private final Price price;

    public ShowerConcealedThreeOutletPriceStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getBathroomPrices().getShowerConcealedThreeOutletLabor(),
                price.getBathroomPrices().getShowerConcealedThreeOutletMaterials(),
                price.getBathroomPrices().getBuriedShowerMixerThreeOutletLabor(),
                price.getBathroomPrices().getBuriedShowerMixerThreeOutletMaterials());
    }

    private Long safeAdd(Long... values) {
        long sum = 0L;
        for (Long val : values) {
            sum += (val != null ? val : 0L);
        }
        return sum;
    }
}