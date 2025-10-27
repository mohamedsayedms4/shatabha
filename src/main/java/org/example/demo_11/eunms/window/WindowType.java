package org.example.demo_11.eunms.window;

import org.example.demo_11.model.Price;

public enum WindowType {
    // ============ ألوميتال ============
    ALUMETAL_PS("ألوميتال PS", AlumetalPsStrategy.class),
    ALUMETAL_JUMPO("ألوميتال Jumpo", AlumetalJumpoStrategy.class),

    // ============ UPVC ============
    UPVC_TURKEY("UPVC Turkey", UpvcTurkeyStrategy.class),
    UPVC_BELGIUM("UPVC Belgium", UpvcBelgiumStrategy.class);

    private final String arabicName;
    private final Class<? extends WindowPriceStrategy> strategyClass;

    WindowType(String arabicName, Class<? extends WindowPriceStrategy> strategyClass) {
        this.arabicName = arabicName;
        this.strategyClass = strategyClass;
    }

    public String getArabicName() {
        return arabicName;
    }

    public WindowPriceStrategy createStrategy(Price price) {
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