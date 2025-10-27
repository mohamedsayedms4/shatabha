package org.example.demo_11.eunms;

/**
 * Represents the finishing status of a residential unit.
 */
public enum SPOT {

    SINGLE_SPOT("سينجل سبوت"),
    NONE("لا يوجد"),
    DOUBLE_SPOT("دبل سبوت");

    private final String arabicName;

    SPOT(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getArabicName() {
        return arabicName;
    }

    // ✅ رجّع الاسم الإنجليزي بدل العربي
    @Override
    public String toString() {
        return name(); // أو احذف الميثود بالكامل
    }
}
