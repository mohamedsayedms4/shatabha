package org.example.demo_11.eunms.shower;

import org.example.demo_11.model.Price;

/**
 * يمثل أنواع مناطق الاستحمام مع ربط كل نوع باستراتيجية حساب السعر الخاصة به.
 */
public enum ShowerArea {
    BATHTUB("بانيو", BathtubStrategy.class),
    JACUZZI("جاكوزي", JacuzziStrategy.class),
    SHOWER_BASE("شاور قدم", ShowerBaseStrategy.class),
    NONE("بدون", NoneStrategy.class);

    private final String arabicName;
    private final Class<? extends ShowerPriceStrategy> strategyClass;

    ShowerArea(String arabicName, Class<? extends ShowerPriceStrategy> strategyClass) {
        this.arabicName = arabicName;
        this.strategyClass = strategyClass;
    }

    public String getArabicName() {
        return arabicName;
    }

    public ShowerPriceStrategy createStrategy(Price price) {
        try {
            return strategyClass.getConstructor(Price.class).newInstance(price);
        } catch (Exception e) {
            throw new RuntimeException("Cannot create strategy for " + this, e);
        }
    }

    // ✅ عشان الإنجليزي يطلع صح في /en
    @Override
    public String toString() {
        return name();
    }
}
