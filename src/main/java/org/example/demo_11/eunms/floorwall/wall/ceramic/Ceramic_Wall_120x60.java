package org.example.demo_11.eunms.floorwall.wall.ceramic;

import org.example.demo_11.eunms.floorwall.BaseClassPriceAreaPermaitair;
import org.example.demo_11.eunms.floorwall.FloorWallPriceStrategy;
import org.example.demo_11.model.Price;

public class Ceramic_Wall_120x60 extends BaseClassPriceAreaPermaitair implements FloorWallPriceStrategy {

    public Ceramic_Wall_120x60(Price price, Double area, Double perimeter) {
        super(price, area, perimeter);
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getFloorWallPrices().getCeramicWall120x60Materials(),
                price.getFloorWallPrices().getCeramicWall120x60Labor(),
                perimeter);
    }

    private Long safeAdd(Long materials, Long labor, double perimeter) {
        long m = (materials != null ? materials : 0L);
        long l = (labor != null ? labor : 0L);
        return Math.round((m + l) * perimeter * 3);
    }
}