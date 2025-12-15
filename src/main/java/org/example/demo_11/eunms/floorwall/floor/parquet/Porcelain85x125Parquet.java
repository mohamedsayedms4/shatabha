package org.example.demo_11.eunms.floorwall.floor.parquet;

import org.example.demo_11.eunms.floorwall.BaseClassPriceAreaPermaitair;
import org.example.demo_11.eunms.floorwall.FloorWallPriceStrategy;
import org.example.demo_11.model.Price;

public class Porcelain85x125Parquet extends BaseClassPriceAreaPermaitair implements FloorWallPriceStrategy {
    public Porcelain85x125Parquet(Price price, Double area, Double perimeter) {
        super(price, area, perimeter);
    }

    @Override
    public Long calculatePrice() {
        return safeAdd(price.getFloorWallPrices().getPorcelain85x125ParquetMaterials(),
                price.getFloorWallPrices().getPorcelain85x125ParquetLabor(),
                area);
    }

    private Long safeAdd(Long materials, Long labor, double area) {
        long m = (materials != null ? materials : 0L);
        long l = (labor != null ? labor : 0L);
        return Math.round((m + l) * area);
    }
}