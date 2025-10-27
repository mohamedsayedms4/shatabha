package org.example.demo_11.eunms;

/**
 * Represents the available locations for the renovation service with Arabic names.
 */
public enum Location {
    CAIRO("القاهرة"),
    GOUNA("الجونة"),
    NORTH_COAST("الساحل الشمالي"),
    HURGHADA("الغردقة"),
    AIN_SOKHNA("العين السخنة"),
    OTHER("أخرى");

    private final String arabicName;

    Location(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getArabicName() {
        return arabicName;
    }

    // ❌ شيل التعريب من toString
    @Override
    public String toString() {
        return name(); // أو ممكن تشيل الميثود دي بالكامل
    }


}
