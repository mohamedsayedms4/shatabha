package org.example.demo_11.eunms.floorwall;


import org.example.demo_11.eunms.floorwall.floor.ceramic.Ceramic_120x60_Floor;
import org.example.demo_11.eunms.floorwall.floor.ceramic.Ceramic_60x60_Floor;
import org.example.demo_11.eunms.floorwall.floor.marble.MarbleFloorBrecciaStrategy;
import org.example.demo_11.eunms.floorwall.floor.marble.MarbleFloorKarraraStrategy;
import org.example.demo_11.eunms.floorwall.floor.marble.MarbleFloorOtherStrategy;
import org.example.demo_11.eunms.floorwall.floor.marble.MarbleFloorPietraGrayStrategy;
import org.example.demo_11.eunms.floorwall.floor.parquet.*;
import org.example.demo_11.eunms.floorwall.floor.porcelain.*;
import org.example.demo_11.model.Price;

/**
 * Enum representing different floor materials with their Arabic names and
 * associated pricing strategy classes.
 * <p>
 * Each enum constant stores the Arabic name of the material and the class
 * that implements {@link FloorWallPriceStrategy} for calculating its price.
 */
public enum FloorMaterial {


//    // Marble Floors
    MARBLE_FLOOR_BRECCIA("رخام أرضيات (بريشيا)", MarbleFloorBrecciaStrategy.class),
    MARBLE_FLOOR_PIETRA_GRAY("رخام أرضيات (بياترا جراي)", MarbleFloorPietraGrayStrategy.class),
    MARBLE_FLOOR_KARRARA("رخام أرضيات (كراره)", MarbleFloorKarraraStrategy.class),
    MARBLE_FLOOR_OTHER("رخام أرضيات (اخرى)", MarbleFloorOtherStrategy.class),


    Parquet_CERMIC("باركية سيراميك", PCD_Parquet.class),
    Parquet_SPC_LOCAL("باركية SPC محلي", SPC_LOCAL_Parquet.class),
    Parquet_SPC_IMPORTED("باركية SPC مستورد", SPC_IMPORTED_Parquet.class),
    Parquet_HDF("باركية HDF ألماني", HDF_GERMAN_Parquet.class),
    Parquet_HDF_WATER("باركية HDF ضد الماء", HDF_WATERPROOF_Parquet.class),
    Parquet_PORCELAIN_60x80("باركية بورسلين 60×80", PORCELAIN_60x80_Parquet.class),
    Parquet_PORCELAIN_85x125("باركية بورسلين 85×125", PORCELAIN_85x125_Parquet.class),

    Local_Porcelain_60x120("بورسلين محلي أرضيات 60×120", Local_Porcelain_60x120_Floor.class),

    Porcelain_Hindi_60x120("بورسلين هندي أرضيات 60×120", Hindi_Porcelain_60x120_Floor.class),
    Porcelain_Hindi_120x180("بورسلين هندي أرضيات 120×180", Hindi_Porcelain_120x180_Floor.class),
    Porcelain_Hindi_120x240("بورسلين هندي أرضيات 120×240", Hindi_Porcelain_120x240_Floor.class),
    Porcelain_Spanish_60x120("بورسلين اسباني أرضيات 60×120", Spanish_Porcelain_60x120_Floor.class),
    Porcelain_Spanish_120x180("بورسلين اسباني أرضيات 120×180", Spanish_Porcelain_120x180_Floor.class),
    Porcelain_Spanish_120x240("بورسلين اسباني أرضيات 120×240", Spanish_Porcelain_120x240_Floor.class),

    Ceramic_60x60("سيراميك أرضيات 60×60", Ceramic_60x60_Floor.class),
    Ceramic_120x60("سيراميك أرضيات 120×60", Ceramic_120x60_Floor.class);

    private final String arabicName;
    private final Class<? extends FloorWallPriceStrategy> strategyClass;

    /**
     * Constructor for {@link FloorMaterial} enum.
     *
     * @param arabicName    the Arabic name of the floor material
     * @param strategyClass the class implementing {@link FloorWallPriceStrategy} for this material
     */
    FloorMaterial(String arabicName, Class<? extends FloorWallPriceStrategy> strategyClass) {
        this.arabicName = arabicName;
        this.strategyClass = strategyClass;
    }

    /**
     * Returns the Arabic name of the floor material.
     *
     * @return Arabic name as String
     */
    public String getArabicName() {
        return arabicName;
    }

    /**
     * Creates an instance of the corresponding pricing strategy for this floor material.
     *
     * @param price     the {@link Price} object containing pricing configuration
     * @param area      the area in square meters
     * @param perimeter the perimeter in meters
     * @return an instance of {@link FloorWallPriceStrategy} for this material
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
     * Returns the enum name in English.
     *
     * @return English name of the enum constant
     */
    @Override
    public String toString() {
        return name();
    }
}
