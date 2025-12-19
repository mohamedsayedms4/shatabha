package org.example.demo_11.eunms;

import org.example.demo_11.model.Price;

public enum BathFloorMaterial {

    // ===== Porcelain - Local =====
    PORCELAIN_LOCAL_60x120("بورسلين محلي 60×120"),

    // ===== Ceramic - Local =====
    CERAMIC_LOCAL_60x60("سيراميك محلي 60×60"),
    CERAMIC_LOCAL_60x120("سيراميك محلي 60×120"),

    // ===== Porcelain - Hindi Imported =====
    PORCELAIN_HINDI_75x75("بورسلين هندي 75×75"),
    PORCELAIN_HINDI_120x60("بورسلين هندي 120×60"),
    PORCELAIN_HINDI_120x180("بورسلين هندي 120×180"),
    PORCELAIN_HINDI_120x240("بورسلين هندي 120×240"),

    // ===== Porcelain - Spanish Imported =====
    PORCELAIN_SPANISH_60x170("بورسلين اسباني 60×170"),
    PORCELAIN_SPANISH_120x180("بورسلين اسباني 120×180"),
    PORCELAIN_SPANISH_120x240("بورسلين اسباني 120×240"),

    // ===== Marble =====
    MARBLE_TYPE_1("رخام نوع 1"),
    MARBLE_TYPE_2("رخام نوع 2"),
    MARBLE_TYPE_3("رخام نوع 3"),
    MARBLE_TYPE_4("رخام نوع 4");

    private final String arabicName;

    BathFloorMaterial(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getArabicName() {
        return arabicName;
    }

    /* ================= PRICE CALCULATION ================= */

    public Long calculatePrice(Price price, Double area, Double perimeter) {
        if (price == null) return 0L;

        long areaPrice;
        long wallPrice;

        switch (this) {

            case CERAMIC_LOCAL_60x60:
                areaPrice = calcArea(
                        price.getFloorWallPrices().getCeramicFloor60x60Materials(),
                        price.getFloorWallPrices().getCeramicFloor60x60Labor(),
                        area
                );
                wallPrice = calcPerimeterTimes3(
                        price.getFloorWallPrices().getCeramicWall60x30Materials(),
                        price.getFloorWallPrices().getCeramicWall60x30Labor(),
                        perimeter
                );
                return areaPrice + wallPrice;

            case CERAMIC_LOCAL_60x120:
                areaPrice = calcArea(
                        price.getBathLocalCeramic60x120Material(),
                        price.getBathLocalCeramic60x120Labor(),
                        area
                );
                wallPrice = calcPerimeterTimes3(
                        price.getBathLocalCeramic60x120Material(),
                        price.getBathLocalCeramic60x120Labor(),
                        perimeter
                );
                return areaPrice + wallPrice;

            case PORCELAIN_LOCAL_60x120:
                areaPrice = calcArea(
                        price.getBathLocalPorcelain60x120Material(),
                        price.getBathLocalPorcelain60x120Labor(),
                        area
                );
                wallPrice = calcPerimeterTimes3(
                        price.getBathLocalPorcelain60x120Material(),
                        price.getBathLocalPorcelain60x120Labor(),
                        perimeter
                );
                return areaPrice + wallPrice;

            case PORCELAIN_HINDI_75x75:
                return calcAreaAndWall(
                        price.getBathHindiPorcelain75x75Material(),
                        price.getBathHindiPorcelain75x75Labor(),
                        area, perimeter
                );

            case PORCELAIN_HINDI_120x60:
                return calcAreaAndWall(
                        price.getBathHindiPorcelain120x60Material(),
                        price.getBathHindiPorcelain120x60Labor(),
                        area, perimeter
                );

            case PORCELAIN_HINDI_120x180:
                return calcAreaAndWall(
                        price.getBathHindiPorcelain120x180Material(),
                        price.getBathHindiPorcelain120x180Labor(),
                        area, perimeter
                );

            case PORCELAIN_HINDI_120x240:
                return calcAreaAndWall(
                        price.getBathHindiPorcelain120x240Material(),
                        price.getBathHindiPorcelain120x240Labor(),
                        area, perimeter
                );

            case PORCELAIN_SPANISH_60x170:
                return calcAreaAndWall(
                        price.getBathSpanishPorcelain60x170Material(),
                        price.getBathSpanishPorcelain60x170Labor(),
                        area, perimeter
                );

            case PORCELAIN_SPANISH_120x180:
                return calcAreaAndWall(
                        price.getBathSpanishPorcelain120x180Material(),
                        price.getBathSpanishPorcelain120x180Labor(),
                        area, perimeter
                );

            case PORCELAIN_SPANISH_120x240:
                return calcAreaAndWall(
                        price.getBathSpanishPorcelain120x240Material(),
                        price.getBathSpanishPorcelain120x240Labor(),
                        area, perimeter
                );

            case MARBLE_TYPE_1:
                return calcAreaAndWall(
                        price.getBathMarbleType1Material(),
                        price.getBathMarbleType1Labor(),
                        area, perimeter
                );

            case MARBLE_TYPE_2:
                return calcAreaAndWall(
                        price.getBathMarbleType2Material(),
                        price.getBathMarbleType2Labor(),
                        area, perimeter
                );

            case MARBLE_TYPE_3:
                return calcAreaAndWall(
                        price.getBathMarbleType3Material(),
                        price.getBathMarbleType3Labor(),
                        area, perimeter
                );

            case MARBLE_TYPE_4:
                return calcAreaAndWall(
                        price.getBathMarbleType4Material(),
                        price.getBathMarbleType4Labor(),
                        area, perimeter
                );

            default:
                return 0L;
        }
    }

    /* ================= HELPERS ================= */

    private long calcArea(Long material, Long labor, Double area) {
        if (area == null) return 0L;
        long m = material != null ? material : 0L;
        long l = labor != null ? labor : 0L;
        return Math.round((m + l) * area);
    }

    private long calcPerimeterTimes3(Long material, Long labor, Double perimeter) {
        if (perimeter == null) return 0L;
        long m = material != null ? material : 0L;
        long l = labor != null ? labor : 0L;
        return Math.round((m + l) * perimeter * 3);
    }

    private long calcAreaAndWall(Long material, Long labor, Double area, Double perimeter) {
        return calcArea(material, labor, area)
                + calcPerimeterTimes3(material, labor, perimeter);
    }
}
