package org.example.demo_11.eunms.floorwall.wall.porcelain;


import org.example.demo_11.eunms.floorwall.BaseClassPriceAreaPermaitair;
import org.example.demo_11.eunms.floorwall.FloorWallPriceStrategy;
import org.example.demo_11.model.Price;

public class Porcelain_Spanish_Wall_60x120 extends BaseClassPriceAreaPermaitair implements FloorWallPriceStrategy {

    public Porcelain_Spanish_Wall_60x120(Price price, Double area, Double perimeter) {
        super(price, area, perimeter);
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getFloorWallPrices().getSpanishPorcelainWall60x120Materials(),
                price.getFloorWallPrices().getSpanishPorcelainWall60x120Labor(),
                perimeter);
    }

    private Long safeAdd(Long materials, Long labor, double perimeter) {
        long m = (materials != null ? materials : 0L);
        long l = (labor != null ? labor : 0L);
        return Math.round((m + l) * perimeter * 3);
    }
}