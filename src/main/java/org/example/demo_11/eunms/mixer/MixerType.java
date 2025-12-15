package org.example.demo_11.eunms.mixer;


import org.example.demo_11.model.Price;

public enum MixerType {
    BASIN_SURFACE("حوض عادي", BasinSurfacePriceStrategy.class),
    BASIN_CONCEALED("حوض دفن", BasinConcealedPriceStrategy.class),
    SHOWER_SURFACE("شاور عادي", ShowerSurfacePriceStrategy.class),
    SHOWER_CONCEALED_2("شاور دفن ", ShowerConcealedTwoOutletPriceStrategy.class),
//    SHOWER_CONCEALED_3("شاور دفن ٣ مخرج", ShowerConcealed3PriceStrategy.class),
    SHOWER_SMART("شاور سمارت", ShowerSmartPriceStrategy.class),
    SHATTAF_SURFACE("شطاف عادي", ShattafSurfacePriceStrategy.class),
    SHATTAF_CONCEALED("شطاف دفن", ShattafConcealedPriceStrategy.class),
    SHATTAF_HANGING("شطاف معلق", ShattafHangingPriceStrategy.class);

    private final String arabicName;
    private final Class<? extends MixerPriceStrategy> strategyClass;

    MixerType(String arabicName, Class<? extends MixerPriceStrategy> strategyClass) {
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

    // ✅ عشان الـ API ترجع إنجليزي صح
    @Override
    public String toString() {
        return name();
    }
}
