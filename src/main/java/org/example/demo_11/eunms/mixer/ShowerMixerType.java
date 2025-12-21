package org.example.demo_11.eunms.mixer;

import org.example.demo_11.model.Price;

public enum ShowerMixerType {
    SHOWER_SURFACE("دش عادي", ShowerSurfacePriceStrategy.class),
    SHOWER_CONCEALED_2("دفن ٢ مخرج", ShowerConcealedTwoOutletPriceStrategy.class),
    SHOWER_SMART("دفن سمارت", ShowerSmartPriceStrategy.class);

    private final String arabicName;
    private final Class<? extends MixerPriceStrategy> strategyClass;

    ShowerMixerType(String arabicName, Class<? extends MixerPriceStrategy> strategyClass) {
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
