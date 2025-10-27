package org.example.demo_11.eunms.ceiling;


import org.example.demo_11.model.Price;

public enum CeilingType {
    BEIT_NOOR("بيت نور", "Beit Noor", BeitNoorStrategy.class),
    SHADOW_GAP("شادو جاب", "Shadow Gap", ShadowGapStrategy.class),
    SHADOW_GAP_LIGHT("شادو جاب + اضاءه", "Shadow Gap + Light", ShadowGapLightStrategy.class),
//    MAGNETIC_TRACK("ماجنتك تراك", "Magnetic Track", MagneticTrackStrategy.class),
    CORNICE_FUTEC_SMALL("كرانيش فيوتك (صغير)", "Cornice Futec Small", CorniceFutecSmallStrategy.class),
    CORNICE_FUTEC_LARGE("كرانيش فيوتك (كبير)", "Cornice Futec Large", CorniceFutecLargeStrategy.class),
    FLAT("مسطح","falt",FlatStrategy.class);

    private final String nameAr;
    private final String nameEn;
    private final Class<? extends CeilingPriceStrategy> strategyClass;

    CeilingType(String nameAr, String nameEn, Class<? extends CeilingPriceStrategy> strategyClass) {
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.strategyClass = strategyClass;
    }

    public CeilingPriceStrategy createStrategy(Price price) {
        try {
            return strategyClass.getConstructor(Price.class).newInstance(price);
        } catch (Exception e) {
            throw new RuntimeException("Cannot create strategy for " + this, e);
        }
    }

    public String getNameAr() {
        return nameAr;
    }

    public String getNameEn() {
        return nameEn;
    }

    // ✅ رجّع القيمة الإنجليزية للاسم الأصلي
    @Override
    public String toString() {
        return name();
    }
}
