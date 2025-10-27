package org.example.demo_11.eunms.floorwall.floor.porcelain;

import org.example.demo_11.eunms.floorwall.BaseClassPriceAreaPermaitair;
import org.example.demo_11.eunms.floorwall.FloorWallPriceStrategy;
import org.example.demo_11.model.Price;

public class Spanish_Porcelain_120x180_Floor extends BaseClassPriceAreaPermaitair implements FloorWallPriceStrategy {
    public Spanish_Porcelain_120x180_Floor(Price price, Double area, Double perimeter) {
        super(price, area, perimeter);
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getFloorWallPrices().getSpanishPorcelainFloor120x180Materials(),
                price.getFloorWallPrices().getSpanishPorcelainFloor120x180Labor(),
                area);
    }

    private Long safeAdd(Long materials, Long labor, double area) {
        long m = (materials != null ? materials : 0L);
        long l = (labor != null ? labor : 0L);
        return Math.round((m + l) * area);
    }
}