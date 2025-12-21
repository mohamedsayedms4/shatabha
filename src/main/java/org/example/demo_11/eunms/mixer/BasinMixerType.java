package org.example.demo_11.eunms.mixer;

import org.example.demo_11.model.Price;

public enum BasinMixerType {
    BASIN_SURFACE("حوض عادي", BasinSurfacePriceStrategy.class),
    BASIN_CONCEALED("حوض دفن", BasinConcealedPriceStrategy.class);

    private final String arabicName;
    private final Class<? extends MixerPriceStrategy> strategyClass;

    BasinMixerType(String arabicName, Class<? extends MixerPriceStrategy> strategyClass) {
        this.arabicName = arabicName;
        this.strategyClass = strategyClass;
    }

    public String getArabicName() {
        return arabicName;
    }

    public MixerPriceStrategy createStrategy(Price price) {
        try {
            return strategyClass.getConstructor(Price.class).newInstance(price);
        } catch (Exception e) {
            throw new RuntimeException("Cannot create strategy for " + this, e);
        }
    }

    @Override
    public String toString() {
        return name();
    }
}
