package org.example.demo_11.eunms.floorwall.wall.paint;

import org.example.demo_11.eunms.floorwall.BaseClassPriceAreaPermaitair;
import org.example.demo_11.eunms.floorwall.FloorWallPriceStrategy;
import org.example.demo_11.model.Price;

public class TagalidMadeMixed extends BaseClassPriceAreaPermaitair implements FloorWallPriceStrategy {

    public TagalidMadeMixed(Price price, Double area, Double perimeter) {
        super(price, area, perimeter);
    }

    @Override
    public Long calculatePrice() {
        if (price.getFloorWallPrices() == null) return 0L;

        Long materials = price.getFloorWallPrices().getTagalidMadeMixedMaterials();
        Long labor = price.getFloorWallPrices().getTagalidMadeMixedLabor();

        return safeAdd(materials, labor, perimeter);
    }

    private Long safeAdd(Long materials, Long labor, Double perimeter) {
        long m = (materials != null ? materials : 0L);
        long l = (labor != null ? labor : 0L);
        double p = (perimeter != null ? perimeter : 0.0);
        return Math.round((m + l) * p * 3);
    }
}
