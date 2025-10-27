package org.example.demo_11.eunms.floorwall;


import org.example.demo_11.eunms.floorwall.wall.DicoarQatifaStrategy;
import org.example.demo_11.eunms.floorwall.wall.DicoarTagalidStrategy;
import org.example.demo_11.eunms.floorwall.wall.PaintNormalStrategy;
import org.example.demo_11.eunms.floorwall.wall.PaintStritchStrategy;
import org.example.demo_11.eunms.floorwall.wall.ceramic.Ceramic_Wall_120x60;
import org.example.demo_11.eunms.floorwall.wall.ceramic.Ceramic_Wall_60x30;
import org.example.demo_11.eunms.floorwall.wall.ceramic.Ceramic_Wall_75x25;
import org.example.demo_11.eunms.floorwall.wall.paint.*;
import org.example.demo_11.eunms.floorwall.wall.porcelain.Porcelain_Local_Wall_60x120;
import org.example.demo_11.eunms.floorwall.wall.porcelain.*;
import org.example.demo_11.model.Price;

/**
 * Enum representing different wall types with their Arabic names and
 * corresponding pricing strategy classes.
 * <p>
 * Each enum constant holds the Arabic name of the wall type and the class
 * implementing {@link FloorWallPriceStrategy} used to calculate its price.
 */
public enum WallType {






    // في الـ Enum
// سيراميك حوائط
    Ceramic_Wall_60x30("سيراميك حوائط 60×30", Ceramic_Wall_60x30.class),
    Ceramic_Wall_75x25("سيراميك حوائط 75×25", Ceramic_Wall_75x25.class),
    Ceramic_Wall_120x60("سيراميك حوائط 120×60", Ceramic_Wall_120x60.class),

    // بورسلين حوائط محلي
    Porcelain_Local_Wall_60x120("بورسلين حوائط محلي 60×120", Porcelain_Local_Wall_60x120.class),

    // بورسلين حوائط هندي
    Porcelain_Hindi_Wall_60x120("بورسلين هندي حوائط 60×120", Porcelain_Hindi_Wall_60x120.class),
    Porcelain_Hindi_Wall_120x180("بورسلين هندي حوائط 120×180", Porcelain_Hindi_Wall_120x180.class),
    Porcelain_Hindi_Wall_120x240("بورسلين هندي حوائط 120×240", Porcelain_Hindi_Wall_120x240.class),

    // بورسلين حوائط اسباني
    Porcelain_Spanish_Wall_60x120("بورسلين اسباني حوائط 60×120", Porcelain_Spanish_Wall_60x120.class),
    Porcelain_Spanish_Wall_120x180("بورسلين اسباني حوائط 120×180", Porcelain_Spanish_Wall_120x180.class),
    Porcelain_Spanish_Wall_120x240("بورسلين اسباني حوائط 120×240", Porcelain_Spanish_Wall_120x240.class),
    // Paint and Panels
    PAINT_NORMAL("دهان عادي", PAINT_NORMAL.class),
    PAINT_DICOAR("دهان ديكور", PAINT_DICOAR.class),
    TAGLIAD_MADE("تجاليد صناعية", TAGLIAD_MADE.class),
    TAGLIAD_NORMAL("تجاليد طبيعي", TAGLIAD_NORMAL.class),
    BANOHAT("بانوهات", BANOHAT.class),
    Paint_Normal("دهان عادي", PaintNormalStrategy.class),
    Paint_Stritch("ديكور سترتش", PaintStritchStrategy.class),
    Dicoar_Qatifa("ديكور قطيفة", DicoarQatifaStrategy.class),
    Dicoar_Tagalid("ديكور تجاليد", DicoarTagalidStrategy.class);


    private final String arabicName;
    private final Class<? extends FloorWallPriceStrategy> strategyClass;

    /**
     * Constructor for {@link WallType} enum.
     *
     * @param arabicName    the Arabic name of the wall type
     * @param strategyClass the class implementing {@link FloorWallPriceStrategy} for this wall type
     */
    WallType(String arabicName, Class<? extends FloorWallPriceStrategy> strategyClass) {
        this.arabicName = arabicName;
        this.strategyClass = strategyClass;
    }

    /**
     * Returns the Arabic name of the wall type.
     *
     * @return Arabic name as String
     */
    public String getArabicName() {
        return arabicName;
    }

    /**
     * Creates an instance of the corresponding pricing strategy for this wall type.
     *
     * @param price     the {@link Price} object containing pricing configuration
     * @param area      the area in square meters
     * @param perimeter the perimeter in meters
     * @return an instance of {@link FloorWallPriceStrategy} for this wall type
     */
    public FloorWallPriceStrategy createStrategy(Price price, Double area, Double perimeter) {
        try {
            return strategyClass
                    .getConstructor(Price.class, Double.class, Double.class)
                    .newInstance(price, area, perimeter);
        } catch (Exception e) {
            throw new RuntimeException("Cannot create strategy for " + this, e);
        }
    }

    /**
     * Returns the enum constant name in English.
     *
     * @return English name of the enum constant
     */
    @Override
    public String toString() {
        return name();
    }
}
