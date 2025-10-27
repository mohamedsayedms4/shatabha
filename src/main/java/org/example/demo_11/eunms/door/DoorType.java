package org.example.demo_11.eunms.door;

import org.example.demo_11.model.Price;

public enum DoorType {

    CUSTOM_MADE("أبواب عمولة", CustomMadeDoorStrategy.class),
    READY_MADE("أبواب جاهزة", ReadyMadeDoorStrategy.class),
    ARMORED("باب مصفح", ArmoredDoorStrategy.class),
    NONE("لا", NoneDoorStrategy.class);

    private final String arabicName;
    private final Class<? extends DoorPriceStrategy> strategyClass;

    DoorType(String arabicName, Class<? extends DoorPriceStrategy> strategyClass) {
        this.arabicName = arabicName;
        this.strategyClass = strategyClass;
    }

    public String getArabicName() {
        return arabicName;
    }

    public DoorPriceStrategy createStrategy(Price price) {
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
