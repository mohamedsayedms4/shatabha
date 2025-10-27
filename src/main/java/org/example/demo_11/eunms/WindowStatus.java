package org.example.demo_11.eunms;

/**
 * Represents the status of windows in a residential unit.
 */
public enum WindowStatus {
    EXISTING("موجودة"),
    NOT_EXIST_OR_TO_BE_REPLACED("غير موجودة أو سيتم تبديلها");

    private final String arabicName;

    WindowStatus(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getArabicName() {
        return arabicName;
    }

    @Override
    public String toString() {
        return arabicName;
    }
}
