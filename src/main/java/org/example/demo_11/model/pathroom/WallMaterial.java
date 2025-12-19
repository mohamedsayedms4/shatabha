//package org.example.demo_11.model.pathroom;
//
//
//import org.example.demo_11.eunms.floorwall.wall.ceramic.*;
//import org.example.demo_11.eunms.floorwall.wall.porcelain.*;
//import org.example.demo_11.model.Price;
//
///**
// * Enum representing different WALL materials (Porcelain/Ceramic/Marble) with their Arabic names and
// * associated pricing strategy classes.
// *
// * NOTE:
// * - Make sure the strategy classes referenced below exist under the imported packages.
// * - I preserved all sizes you wrote (including uncommon ones like 120×740, 170×740).
// */
//public enum WallMaterial {
//
//    // ===================== Marble (Walls) =====================
//    MARBLE_WALL("رخام حوائط", MarbleWallStrategy.class),
//
//    // ===================== Porcelain (Walls) =====================
//    PORCELAIN_LOCAL_WALL_60x120("بورسلين محلي حوائط 60×120", Local_Porcelain_60x120_Wall.class),
//
//    // Hindi Imported (Walls)
//    PORCELAIN_HINDI_WALL_60x60("بورسلين هندي مستورد حوائط 60×60", Hindi_Porcelain_60x60_Wall.class),
//    PORCELAIN_HINDI_WALL_170x60("بورسلين هندي مستورد حوائط 170×60", Hindi_Porcelain_170x60_Wall.class),
//    PORCELAIN_HINDI_WALL_75x75("بورسلين هندي مستورد حوائط 75×75", Hindi_Porcelain_75x75_Wall.class),
//    PORCELAIN_HINDI_WALL_120x60("بورسلين هندي مستورد حوائط 120×60", Hindi_Porcelain_120x60_Wall.class),
//
//    // TvDe / Tvne / Tvpe (Walls) - kept exactly as you wrote
//    PORCELAIN_HINDI_WALL_TVDE_1_60x170("بورسلين هندي مستورد حوائط TvDe 1 (60×170)", Hindi_Porcelain_TvDe1_60x170_Wall.class),
//    PORCELAIN_HINDI_WALL_TVNE_2_170x180("بورسلين هندي مستورد حوائط Tvne 2 (170×180)", Hindi_Porcelain_Tvne2_170x180_Wall.class),
//    PORCELAIN_HINDI_WALL_TVPE_3_120x740("بورسلين هندي مستورد حوائط Tvpe 3 (120×740)", Hindi_Porcelain_Tvpe3_120x740_Wall.class),
//    PORCELAIN_HINDI_WALL_TVDE_4_60x170("بورسلين هندي مستورد حوائط TvDe 4 (60×170)", Hindi_Porcelain_TvDe4_60x170_Wall.class),
//
//    // Additional sizes listed (Walls)
//    PORCELAIN_HINDI_WALL_170x180("بورسلين هندي مستورد حوائط 170×180", Hindi_Porcelain_170x180_Wall.class),
//    PORCELAIN_HINDI_WALL_170x740("بورسلين هندي مستورد حوائط 170×740", Hindi_Porcelain_170x740_Wall.class),
//
//    // Spanish Imported (Walls)
//    PORCELAIN_SPANISH_WALL_60x120("بورسلين اسباني مستورد حوائط 60×120", Spanish_Porcelain_60x120_Wall.class),
//    PORCELAIN_SPANISH_WALL_120x180("بورسلين اسباني مستورد حوائط 120×180", Spanish_Porcelain_120x180_Wall.class),
//    PORCELAIN_SPANISH_WALL_120x240("بورسلين اسباني مستورد حوائط 120×240", Spanish_Porcelain_120x240_Wall.class),
//
//    // ===================== Ceramic (Walls) =====================
//    CERAMIC_WALL_60x120("سيراميك حوائط 60×120", Ceramic_60x120_Wall.class),
//    CERAMIC_WALL_60x60("سيراميك حوائط 60×60", Ceramic_60x60_Wall.class);
//
//    private final String arabicName;
//    private final Class<? extends FloorWallPriceStrategy> strategyClass;
//
//    WallMaterial(String arabicName, Class<? extends FloorWallPriceStrategy> strategyClass) {
//        this.arabicName = arabicName;
//        this.strategyClass = strategyClass;
//    }
//
//    public String getArabicName() {
//        return arabicName;
//    }
//
//    public FloorWallPriceStrategy createStrategy(Price price, Double area, Double perimeter) {
//        try {
//            return strategyClass
//                    .getConstructor(Price.class, Double.class, Double.class)
//                    .newInstance(price, area, perimeter);
//        } catch (Exception e) {
//            throw new RuntimeException("Cannot create strategy for " + this, e);
//        }
//    }
//
//    @Override
//    public String toString() {
//        return name();
//    }
//}
