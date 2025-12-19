package org.example.demo_11.eunms.exhaust;


import org.example.demo_11.model.Price;

public enum ExhaustType {

    WINDOW_EXHAUST("شفاط شباك", WindowExhaustStrategy.class),
    CEILING_EXHAUST("شفاط سقف", CeilingExhaustStrategy.class),
    NONE("لا يوجد", NoneExhaustStrategy.class);

    private final String arabicName;
    private final Class<? extends ExhaustPriceStrategy> strategyClass;

    ExhaustType(String arabicName, Class<? extends ExhaustPriceStrategy> strategyClass) {
        this.arabicName = arabicName;
        this.strategyClass = strategyClass;
    }

    public String getArabicName() {
        return arabicName;
    }

    public ExhaustPriceStrategy createStrategy(Price price) {
        try {
            return strategyClass.getConstructor(Price.class).newInstance(price);
        } catch (Exception e) {
            throw new RuntimeException("Cannot create strategy for " + this, e);
        }
    }

    // ✅ ترجع الاسم الإنجليزي للـ API
    @Override
    public String toString() {
        return name();
    }
}
