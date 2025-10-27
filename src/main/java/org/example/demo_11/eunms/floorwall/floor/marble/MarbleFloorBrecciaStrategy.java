package org.example.demo_11.eunms.floorwall.floor.marble;


import org.example.demo_11.eunms.floorwall.BaseClassPriceAreaPermaitair;
import org.example.demo_11.eunms.floorwall.FloorWallPriceStrategy;
import org.example.demo_11.model.Price;

public class MarbleFloorBrecciaStrategy extends BaseClassPriceAreaPermaitair implements FloorWallPriceStrategy {
    public MarbleFloorBrecciaStrategy(Price price, Double area, Double perimeter) {
        super(price, area, perimeter);
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getFloorWallPrices().getMarbleFloorBrecciaMaterials(),
                price.getFloorWallPrices().getMarbleFloorBrecciaLabor(),
                area);
    }

    private Long safeAdd(Long materials, Long labor, double area) {
        long m = (materials != null ? materials : 0L);
        long l = (labor != null ? labor : 0L);
        return Math.round((m + l) * area);
    }
}
