package org.example.demo_11.eunms.mixer;
import org.example.demo_11.model.Price;

public class ShowerConcealed3PriceStrategy implements MixerPriceStrategy {

    private final Price price;

    public ShowerConcealed3PriceStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getBathroomPrices().getShowerConcealed3Labor(), price.getBathroomPrices().getShowerConcealed3Materials(),
                price.getBathroomPrices().getBuriedShowerMixer3OutletLabor(),price.getBathroomPrices().getBuriedShowerMixer3OutletMaterials());
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
