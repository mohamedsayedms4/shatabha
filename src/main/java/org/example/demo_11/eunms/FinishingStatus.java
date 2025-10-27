package org.example.demo_11.eunms;

/**
 * Represents the finishing status of a residential unit.
 */
public enum FinishingStatus {
    RED_BRICK("طوب أحمر"),
    PARTIAL_FINISH("نص تشطيب");

    private final String arabicName;

    FinishingStatus(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getArabicName() {
        return arabicName;
    }

    // ✅ رجع الاسم الإنجليزي بدل العربي
    @Override
    public String toString() {
        return name(); // أو احذف toString() بالكامل
    }
}
