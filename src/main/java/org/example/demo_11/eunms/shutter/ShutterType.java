package org.example.demo_11.eunms.shutter;

import org.example.demo_11.model.Price;

public enum ShutterType {
    SHUTTER_PROTECTION("شاتر - حمايه", ShutterProtectionStrategy.class),
    SHUTTER_WEATHER_RESISTANT("شاتر - ضد عوامل الجو", ShutterWeatherResistantStrategy.class),
    SHUTTER_ANTI_THEFT("شاتر - ضد السرقه", ShutterAntiTheftStrategy.class);

    private final String arabicName;
    private final Class<? extends ShutterPriceStrategy> strategyClass;

    ShutterType(String arabicName, Class<? extends ShutterPriceStrategy> strategyClass) {
        this.arabicName = arabicName;
        this.strategyClass = strategyClass;
    }

    public String getArabicName() {
        return arabicName;
    }

    public ShutterPriceStrategy createStrategy(Price price) {
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