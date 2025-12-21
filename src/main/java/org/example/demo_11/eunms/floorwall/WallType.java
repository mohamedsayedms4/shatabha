package org.example.demo_11.eunms.floorwall;

import org.example.demo_11.eunms.floorwall.wall.paint.PaintDecorative;
import org.example.demo_11.eunms.floorwall.wall.paint.BanohAt;
import org.example.demo_11.eunms.floorwall.wall.paint.TagalidMadeMarble;
import org.example.demo_11.eunms.floorwall.wall.paint.TagalidMadeMixed;
import org.example.demo_11.eunms.floorwall.wall.paint.TagalidMadeWood;
import org.example.demo_11.eunms.floorwall.wall.paint.TagalidNaturalMarble;
import org.example.demo_11.eunms.floorwall.wall.paint.TagalidNaturalWood;
import org.example.demo_11.model.Price;

/**
 * Enum representing different wall types with their Arabic names and
 * corresponding pricing strategy classes.
 *
 * Each enum constant holds the Arabic name of the wall type and the class
 * implementing {@link FloorWallPriceStrategy} used to calculate its price.
 */
public enum WallType {

    // 1- دهانات
    PAINT_NORMAL("دهانات عاديه", BanohAt.class),
    PAINT_DECORATIVE("دهانات ديكوريه", PaintDecorative.class),

    // 2- تجاليد
    // 2.1 تجاليد طبيعي
    TAGALID_NATURAL_MARBLE("تجاليد طبيعي - رخام", TagalidNaturalMarble.class),
    TAGALID_NATURAL_WOOD("تجاليد طبيعي - خشب", TagalidNaturalWood.class),

    // 2.2 تجاليد صناعي
    TAGALID_MADE_WOOD("تجاليد صناعي - خشب", TagalidMadeWood.class),
    TAGALID_MADE_MARBLE("تجاليد صناعي - رخام", TagalidMadeMarble.class),
    TAGALID_MADE_MIXED("تجاليد صناعي - متنوعه", TagalidMadeMixed.class);

    private final String arabicName;
    private final Class<? extends FloorWallPriceStrategy> strategyClass;

    WallType(String arabicName, Class<? extends FloorWallPriceStrategy> strategyClass) {
        this.arabicName = arabicName;
        this.strategyClass = strategyClass;
    }

    public String getArabicName() {
        return arabicName;
    }

    public FloorWallPriceStrategy createStrategy(Price price, Double area, Double perimeter) {
        try {
            return strategyClass
                    .getConstructor(Price.class, Double.class, Double.class)
                    .newInstance(price, area, perimeter);
        } catch (Exception e) {
            throw new RuntimeException("Cannot create strategy for " + this, e);
        }
    }

    @Override
    public String toString() {
        return name();
    }
}
