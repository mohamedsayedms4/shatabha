package org.example.demo_11.eunms.shower;

// استراتيجية لكل نوع

import org.example.demo_11.model.Price;

public class ShowerBaseStrategy implements ShowerPriceStrategy {
    private final Price price;

    public ShowerBaseStrategy(Price price) {
        this.price = price;
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getBathroomPrices().getShower_baseLabor(), price.getBathroomPrices().getShower_baseMaterials(),
                price.getBathroomPrices().getShowerBaseGlass80_210Labor(),price.getBathroomPrices().getShowerBaseGlass80_210Materials()
                );
    }

    private Long safeAdd(Long... values) {
        long sum = 0L;
        for (Long val : values) {
            sum += (val != null ? val : 0L);
        }
        return sum;
    }

}
