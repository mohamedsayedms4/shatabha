package org.example.demo_11.eunms.floorwall.wall;

import org.example.demo_11.eunms.floorwall.BaseClassPriceAreaPermaitair;
import org.example.demo_11.eunms.floorwall.FloorWallPriceStrategy;
import org.example.demo_11.model.Price;

public class PaintStritchStrategy extends BaseClassPriceAreaPermaitair implements FloorWallPriceStrategy {

    public PaintStritchStrategy(Price price, Double area, Double perimeter) {
        super(price, area, perimeter);
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getCeilingPrices().getCelingPaint_StritchMaterials(),
                price.getCeilingPrices().getCelingPaint_StritchLabor(),
                area);
    }

    private Long safeAdd(Long materials, Long labor, double area) {
        long m = (materials != null ? materials : 0L);
        long l = (labor != null ? labor : 0L);
        return Math.round((m + l) * area);
    }
}


