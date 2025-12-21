package org.example.demo_11.eunms.mixer;

import org.example.demo_11.model.Price;

public enum ShattafMixerType {
    SHATTAF_SURFACE("شطاف عادي", ShattafSurfacePriceStrategy.class),
    SHATTAF_CONCEALED("شطاف مدفون", ShattafConcealedPriceStrategy.class),
    SHATTAF_HANGING("شطاف معلق", ShattafHangingPriceStrategy.class);

    private final String arabicName;
    private final Class<? extends MixerPriceStrategy> strategyClass;

    ShattafMixerType(String arabicName, Class<? extends MixerPriceStrategy> strategyClass) {
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
