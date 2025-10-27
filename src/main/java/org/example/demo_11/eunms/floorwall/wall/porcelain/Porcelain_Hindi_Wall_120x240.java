package org.example.demo_11.eunms.floorwall.wall.porcelain;


import org.example.demo_11.eunms.floorwall.BaseClassPriceAreaPermaitair;
import org.example.demo_11.eunms.floorwall.FloorWallPriceStrategy;
import org.example.demo_11.model.Price;

public class Porcelain_Hindi_Wall_120x240 extends BaseClassPriceAreaPermaitair implements FloorWallPriceStrategy {

    public Porcelain_Hindi_Wall_120x240(Price price, Double area, Double perimeter) {
        super(price, area, perimeter);
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getFloorWallPrices().getHindiPorcelainWall120x240Materials(),
                price.getFloorWallPrices().getHindiPorcelainWall120x240Labor(),
                perimeter);
    }

    private Long safeAdd(Long materials, Long labor, double perimeter) {
        long m = (materials != null ? materials : 0L);
        long l = (labor != null ? labor : 0L);
        return Math.round((m + l) * perimeter * 3);
    }
}