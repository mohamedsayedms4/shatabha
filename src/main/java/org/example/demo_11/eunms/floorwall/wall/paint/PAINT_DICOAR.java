package org.example.demo_11.eunms.floorwall.wall.paint;

import org.example.demo_11.eunms.floorwall.BaseClassPriceAreaPermaitair;
import org.example.demo_11.eunms.floorwall.FloorWallPriceStrategy;
import org.example.demo_11.model.Price;

public class PAINT_DICOAR extends BaseClassPriceAreaPermaitair implements FloorWallPriceStrategy {
    public PAINT_DICOAR(Price price, Double area, Double perimeter) {
        super(price, area, perimeter);
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getFloorWallPrices().getPAINT_DICOARMaterials(),
                price.getFloorWallPrices().getPAINT_DICOARLabor(),
                perimeter);
    }
    private Long safeAdd(Long materials, Long labor, double area) {
        long m = (materials != null ? materials : 0L);
        long l = (labor != null ? labor : 0L);
        return Math.round((m + l) * perimeter*3);
    }
}
