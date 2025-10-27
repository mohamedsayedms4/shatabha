package org.example.demo_11.eunms.sink;

import org.example.demo_11.model.Price;

public enum SinkType {
    HALF_PEDESTAL("حوض نص ركبة", new HalfPedestalSinkStrategy()),
    MARBLE("رخام", new MarbleSinkStrategy()),
    PORCELAIN("بورسلين", new PorcelainSinkStrategy()),
    ABOVE_UNIT("فوق الوحدة", new AboveUnitSinkStrategy());

    private final String arabicName;
    private final SinkPriceStrategy strategy;

    SinkType(String arabicName, SinkPriceStrategy strategy) {
        this.arabicName = arabicName;
        this.strategy = strategy;
    }

    public String getArabicName() {
        return arabicName;
    }

    public Long calculatePrice(Price price) {
        return strategy.calculatePrice(price);
    }

    // ✅ ترجع الاسم الإنجليزي عند الحاجة
    @Override
    public String toString() {
        return name();
    }
}
