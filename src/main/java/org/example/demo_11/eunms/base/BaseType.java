package org.example.demo_11.eunms.base;


import org.example.demo_11.model.Price;

/**
 * يمثل أنواع القواعد (Base Types) في الحمامات مع ربط كل نوع باستراتيجية حساب السعر الخاصة به.
 */
public enum BaseType {
    WALL_HUNG_CONCEALED("معلقة - صندوق دفن", WallHungConcealedStrategy.class),
    FLOOR_STANDING("عادية", FloorStandingStrategy.class);

    private final String arabicName;
    private final Class<? extends BasePriceStrategy> strategyClass;

    BaseType(String arabicName, Class<? extends BasePriceStrategy> strategyClass) {
        this.arabicName = arabicName;
        this.strategyClass = strategyClass;
    }

    public String getArabicName() {
        return arabicName;
    }

    public BasePriceStrategy createStrategy(Price price) {
        try {
            return strategyClass.getConstructor(Price.class).newInstance(price);
        } catch (Exception e) {
            throw new RuntimeException("Cannot create strategy for " + this, e);
        }
    }

    // ✅ خليه يرجّع الاسم الإنجليزي بدل العربي
    @Override
    public String toString() {
        return name(); // أو احذف الميثود بالكامل
    }
}
