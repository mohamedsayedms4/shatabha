package org.example.demo_11.eunms;

/**
 * Represents the finishing status of a residential unit.
 */
public enum MAGNTIC_TRACK {
    MAGNTIC_TRACK_ROOM("مجانتك تراك غرفة"),
    NONE("لا يوجد"),
    MAGNTIC_TRACK_RESPTION("مجانتك تراك ريسيبشن");


    private final String arabicName;

    MAGNTIC_TRACK(String arabicName) {
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
