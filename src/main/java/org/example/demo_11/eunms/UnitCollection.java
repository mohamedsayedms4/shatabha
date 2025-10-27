package org.example.demo_11.eunms;

/**
 * Represents different collections/types of residential units.
 */
public enum UnitCollection {
    NEW_BRAND("جديدة"),
    RENOVATION("تجديد");

    private final String arabicName;

    UnitCollection(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getArabicName() {
        return arabicName;
    }

    // ✅ رجّع الاسم الإنجليزي بدل العربي
    @Override
    public String toString() {
        return name(); // أو احذف toString() بالكامل
    }
}
