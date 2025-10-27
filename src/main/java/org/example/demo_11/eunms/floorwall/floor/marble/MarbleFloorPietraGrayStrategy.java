package org.example.demo_11.eunms.floorwall.floor.marble;

import org.example.demo_11.eunms.floorwall.BaseClassPriceAreaPermaitair;
import org.example.demo_11.eunms.floorwall.FloorWallPriceStrategy;
import org.example.demo_11.model.Price;

public class MarbleFloorPietraGrayStrategy extends BaseClassPriceAreaPermaitair implements FloorWallPriceStrategy {

    public MarbleFloorPietraGrayStrategy(Price price, Double area, Double perimeter) {
        super(price, area, perimeter);
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getFloorWallPrices().getMarbleFloorPietraGrayMaterials(),
                price.getFloorWallPrices().getMarbleFloorPietraGrayLabor(),
                area);
    }

    private Long safeAdd(Long materials, Long labor, double area) {
        long m = (materials != null ? materials : 0L);
        long l = (labor != null ? labor : 0L);
        return Math.round((m + l) * area);
    }
}
